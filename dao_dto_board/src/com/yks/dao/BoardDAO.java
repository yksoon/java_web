package com.yks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yks.model.BoardModel;

public class BoardDAO {
	// 사용할 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 데이터베이스 접속 설정 정보
	/** JDBC DRIVER 패키지정보 */
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	/** 데이터베이스 URL */
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/dao_db";
	
	/** 데이터베이스 아이디 */
	private final String DB_ID = "root";
	
	/** 데이터베이스 비밀번호 */
	private final String DB_PWD = "Fhrhkd1490!";

	public BoardDAO() {		// 기본생성자
	}
	
	/**
	 * DB 접속 메서드
	 */
	private void connectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(DB_URL, DB_ID, DB_PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver load ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB connect ERR : " + e.getMessage());
		}
	}
	
	/**
	 * 게시판 목록 조회
	 * @param boardModel
	 * @return
	 */
	public List<BoardModel> selectList(BoardModel boardModel){
		int pageNum = Integer.parseInt(boardModel.getPageNum());	// "1" => 1
		int listCount = boardModel.getListCount();	// 한 페이지 게시물 수
		String searchType = boardModel.getSearchType();	// 검색종류
		String searchText = boardModel.getSearchText();	// 검색어
		// 처음 호출되었을때 selectCount()에 의해 ""값으로 초기화
		
		String whereSQL = "";	//조건 부분 쿼리만 저장
		List<BoardModel> boardList = null;	// 결과 값들을 각각 BoardModel 객체로
		// 저장한 후, 한번에 반환시키기 위한 ArrayList<BoardModel>을 저장
		// ArrayList는 List 인터페이스를 구현받았기 때문에 List<BoardModel> 타입도 가능
		
		try {
			if(!"".equals(searchText)){		// 검색어가 있을 경우에만
				
				if("ALL".equals(searchType)){	// 전체 검색일 경우
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') OR WRITER LIKE CONCAT('%',?,'%') OR CONTENTS LIKE CONCAT('%',?,'%') ";
				}else if("SUBJECT".equals(searchType)){	// 제목 검색일 경우
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') ";
				}else if("WRITER".equals(searchType)){	// 작성자 검색일 경우
					whereSQL = " WHERE WRITER LIKE CONCAT('%',?,'%') ";
				}else if("CONTENTS".equals(searchType)){	// 내용 검색일 경우
					whereSQL = " WHERE CONTENTS LIKE CONCAT('%',?,'%') ";
				}
			}
			
			// 데이터베이스 호출
			this.connectDB();
			
			// 게시물 목록 조회 (목록 화면에 필요한 필드만)
			String end = "ORDER BY NUM DESC LIMIT ?, ?";
			String first = "SELECT NUM, SUBJECT, WRITER, REG_DATE, HIT FROM board1 ";
			String query = first + whereSQL + end;
			this.pstmt = this.conn.prepareStatement(query);
			
			if(!"".equals(whereSQL)){	// 검색 쿼리가 있을 경우에만
				
				if("ALL".equals(searchType)){	// 전체 검색일 경우 ? 다섯개
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
					this.pstmt.setInt(4, listCount * (pageNum -1));	// 페이지의 시작번호
					this.pstmt.setInt(5, listCount);				// 조회 갯수
				}else{
					this.pstmt.setString(1, searchText);			// 그 외의 검색일 경우 ? 세개
					this.pstmt.setInt(2, listCount * (pageNum -1));
					this.pstmt.setInt(3, listCount);
				}
			}else{
				this.pstmt.setInt(1, listCount * (pageNum -1));	// 페이지의 시작 번호
				this.pstmt.setInt(2, listCount);				// 조회 갯수
			}
			
			// 조회 실행
			this.rs = this.pstmt.executeQuery();
			
			// LIST 객체에 저장하기 위한 객체 생성
			boardList = new ArrayList<BoardModel>();
			
			while(this.rs.next()){
				boardModel = new BoardModel();	// 각 레코드를 하나의 객체로
				boardModel.setNum(this.rs.getInt("NUM"));
				boardModel.setSubject(this.rs.getString("SUBJECT"));
				boardModel.setWriter(this.rs.getString("WRITER"));
				boardModel.setHit(this.rs.getInt("HIT"));
				boardModel.setReg_date(this.rs.getString("REG_DATE"));
				
				boardList.add(boardModel);	// ArrayList 에 추가
			}
			
		} catch (Exception e) {
			System.out.println("SelectList Query ERR : " + e.getMessage());
		} finally {
			this.close(rs, pstmt, conn);
		}	
//		String whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%')";
//		String query = "SELECT NUM, SUBJECT, WRITER, REG_DATE, HIT FROM dao_board " + whereSQL + "ORDER BY NUM DESC LIMIT ?, ?";
		
		return boardList;
	}
	
	/**
	 * 게시글 총 갯수 조회
	 * @param boardModel
	 * @return
	 */
	public int selectCount(BoardModel boardModel) {
		int totalCount = 0;		// 전체 조회 또는 검색어를 통한 조회 시 총 레코드 갯수 저장
		String searchType = boardModel.getSearchType();
		String searchText = boardModel.getSearchText();
		String whereSQL = "";	// select 쿼리의 조건 부분만 저장
		
		try {
			// 검색어 쿼리문 생성
			if(!"".equals(searchText)){		// 검색어가 있을 경우에만
				
				if("ALL".equals(searchType)){	// 전체 검색일 경우
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') OR WRITER LIKE CONCAT('%',?,'%') OR CONTENTS LIKE CONCAT('%',?,'%') ";
				}else if("SUBJECT".equals(searchType)){	// 제목 검색일 경우
					whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%') ";
				}else if("WRITER".equals(searchType)){	// 작성자 검색일 경우
					whereSQL = " WHERE WRITER LIKE CONCAT('%',?,'%') ";
				}else if("CONTENTS".equals(searchType)){	// 내용 검색일 경우
					whereSQL = " WHERE CONTENTS LIKE CONCAT('%',?,'%') ";
				}
			}
			
			// 데이터베이스 객체 실행
			connectDB();
			
			// 게시물의 총 수를 얻는 쿼리 실행
			String query = "SELECT COUNT(NUM) AS TOTAL FROM board1" + whereSQL;
			this.pstmt = this.conn.prepareStatement(query);
			if(!"".equals(whereSQL)){
				if("ALL".equals(searchType)){
					this.pstmt.setString(1, searchText);
					this.pstmt.setString(2, searchText);
					this.pstmt.setString(3, searchText);
				}else{
					this.pstmt.setString(1, searchText);	// 그 외의 검색일 경우 ? 한개
				}
			}
			this.rs = this.pstmt.executeQuery();	// 쿼리 실행
			if(rs.next()){
				totalCount = this.rs.getInt("TOTAL");	// 결과 필드명을 이용
			}
		} catch (Exception e) {
			System.out.println("Query ERR : " + e.getMessage());
		} finally {
			close(rs, pstmt, conn);	// 사용한 객체 종료
		}

//		String whereSQL = " WHERE SUBJECT LIKE CONCAT('%',?,'%')";
//		String query = "SELECT COUNT(NUM) AS TOTAL FROM dao_board" + whereSQL;
		
		return totalCount;	// 결과값 반환 (BoardListServlet 의 doGet()에게)
	}	// END selectCount()
	
	
	/**
	 * 게시판 상세 조회
	 * @param boardModel
	 * @return
	 */
	public BoardModel select(BoardModel boardModel){
		// 데이터베이스 객체
		connectDB();
		
		// 게시물 상세 조회 쿼리 실행
		String query = "SELECT NUM, SUBJECT, CONTENTS, WRITER, HIT, REG_DATE " + "FROM board1 WHERE NUM = ?";
		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardModel.getNum());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()){
				boardModel.setNum(this.rs.getInt("NUM"));
				boardModel.setSubject(this.rs.getString("SUBJECT"));
				boardModel.setContents(this.rs.getString("CONTENTS"));
				boardModel.setWriter(this.rs.getString("WRITER"));
				boardModel.setHit(this.rs.getInt("HIT"));
				boardModel.setReg_date(this.rs.getString("REG_DATE"));
			}
		} catch (SQLException e) {
			System.out.println("select Query ERR : " + e.getMessage());
		}finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return boardModel;
	}	// select(BoardModel boardModel) END
	
	/**
	 * 게시판 등록 처리
	 * @param boardModel
	 */
	public void insert(BoardModel boardModel) {
		// 데이터베이스 객체
		connectDB();
		
//		String query = "INSERT INTO dao_board (SUBJECT, WRITER, CONTENTS, IP, HIT, REG_DATE, MOD_DATE) VALUES (?, ?, ?, ?, 0, NOW(), NOW())";
		String first = "INSERT INTO board1 (SUBJECT, WRITER, CONTENTS, IP, HIT, REG_DATE, MOD_DATE) ";
		String last = "VALUES (?, ?, ?, ?, 0, NOW(), NOW())";
		String query = first + last;
		try {
			this.pstmt = this.conn.prepareStatement(query);
			
			this.pstmt.setString(1, ChangeEncodingClass.toLatin(boardModel.getSubject()));
			this.pstmt.setString(2, ChangeEncodingClass.toLatin(boardModel.getWriter()));
			this.pstmt.setString(3, ChangeEncodingClass.toLatin(boardModel.getContents()));
			this.pstmt.setString(4, boardModel.getIp());
			this.pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Query ERR : " + e.getMessage());
		}
	}	// insert(BoardModel boardModel) END
	
	/**
	 * 게시판 수정 처리
	 * @param boardModel
	 */
	public void update(BoardModel boardModel) {
		// 데이터베이스 객체
		connectDB();
		
		String query = "UPDATE board1 SET SUBJECT = ?, WRITER = ?, CONTENTS = ?, IP = ?, MOD_DATE = NOW() WHERE NUM = ?";
		
		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.pstmt.setString(4, boardModel.getIp());
			this.pstmt.setInt(5, boardModel.getNum());
			this.pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update Query ERR : " + e.getMessage());
		}finally {
			close(null, pstmt, conn);
		}
		
	}
	
	/**
	 * 게시판 조회수 증가 수정 처리
	 * @param boardModel
	 */
	public void updateHit (BoardModel boardModel) {
		// 데이터베이스 객체
		connectDB();
		
		// 조회숴 증가 쿼리 실행
		String query = "UPDATE board1 SET HIT=HIT+1 WHERE NUM = ?";
		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardModel.getNum());
			this.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateHit Query ERR : " + e.getMessage());
		} finally {
			close(null, pstmt, conn);
		}
	}
	
	/**
	 * 게시판 삭제 처리
	 * @param boardModel
	 */
	public void delete(BoardModel boardModel) {
		// 데이터베이스
		connectDB();
		
		String query = "DELETE FROM board1 WHERE NUM = ?";
		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardModel.getNum());
			this.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, pstmt, conn);
		}
	}
	
	/**
	 * 사용한 객체를 닫음
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public void close (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	// public void close() END
	
	
}
