package board.dao;

/**	Connection, PreparedStatement, 쿼리 실행관련*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**Context(Interface이다.), InitialContext 객체  => Context.xml <Context>**/
//lookup(찾고자하는 이름(JNDI명)) -> 탐색기에서 검색하는 것과 같은 느낌
import javax.naming.Context;
import javax.naming.InitialContext;

/**---------------------------------------------------*/
//추가 (JNDI 방식)
//DataSource 객체 -> getConnection() => Context.xml <Resource>
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAO {
	DataSource ds; // => Context.xml <Resource type="~~">

	// 생성자 : DataSource 얻기 : InitialContext와 JNDI명
	public BoardDAO() {
		try {
			// InitialContext ctx=new InitialContext(); 이것도 가능.
			// 이유 : InitialContext implements Context
			Context ctx = new InitialContext();

			// lookup("java:comp/env/찾고자하는 JNDI이름")
			// 찾고자하는 JNDI이름 : => Context.xml <Resource name="~~">
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds : " + ds);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 글 목록 조회 메서드 */
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
			} // end while

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;	// ListActionController 로 반환
	} // list() END

	
	
	
	
	
	/** 글 번호 얻기 메서드(글 쓰기 메서드에서 사용) */


	
	/** 글 쓰기 메서드 */


	
	/** 글 자세히 보기 메서드 */


	
	/** 글 수정하기 메서드 */


	
	/** 글 삭제하기 메서드 */


	
	/** 검색하기 메서드 */


}
