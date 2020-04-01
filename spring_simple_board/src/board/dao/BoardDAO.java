package board.dao;

/**
 * Connection, PreparedStatement, ResultSet 쿼리 실행 관련
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Context(Interface이다.), InitialContext 객체 => Context.xml <Context>
 * lookup(찾고자 하는 이름(JNDI명)) -> 탐색기에서 검색하는 것과 같은 느낌
 */
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * 추가 (JNDI 방식)
 * DataSource 객체 -> detConnection() => Context.xml <Resource>
 */
import javax.sql.DataSource;

import board.dto.BoardDTO;

/**
 * 각 쿼리를 실제로 수행하는 class
 * 생성자를 통해 Context로부터 DB접속.
 * 조회, 검색, 수정, 삭제 등의 쿼리를 수행하고 결과를 반환
 * 각 Controller 에서 호출되는 메서드들을 보유
 * @author USER
 *
 */
public class BoardDAO {
	
	DataSource ds;	// Context.xml <Resource type="~~">

	public BoardDAO() {
		try {
			// InitialContext ctx = new InitialContext(); 이것도 가능
			// 이유 : InitialContext implements Context
			Context ctx = new InitialContext();
			
			// lookup("java:comp/env/찾고자하는 JNDI이름")
			// 찾고자하는 JNDI이름 : => Context.xml <Resource type="~~">
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds : " + ds);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 글 목록 메서드
	 */
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		
		try {
			String sql = "SELECT * FROM springboard ORDER BY num desc";
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO data = new BoardDTO();
				
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setDate(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				
				list.add(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	// list() END
	
	/**
	 * 글 번호 얻기 메서드 (글 쓰기 메서드에서 사용)
	 */
	public int getNewNum() {
		int newNum = 1;
		
		try {
			String sql = "select max(num) from springboard";
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				// 가상필드이기 때문에, 필드명을 쓸수 없어서 인덱스(1)를 사용.
				newNum = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newNum;
	}
	
	/**
	 * 글 쓰기 메서드
	 * public void write(BoardCommand data){}가 정석
	 * 그러나 세개만 받기위해서 아래와 같이 작성
	 */
	public void write(String author, String title, String content) {
		try{
			int newNum = getNewNum();
			System.out.println("newNum : " + newNum);
			
			String sql = "insert into springboard (num, author, title, content) " + "values (?,?,?,?)";
			System.out.println(sql);	// 한글 깨지는지 확인
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, newNum);
			stmt.setString(2, author);
			stmt.setString(3, title);
			stmt.setString(4, content);
			stmt.executeUpdate();		// == stmt.ewecuteUpdate(sql);
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
