<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	String mySQL_id = "root";
	String mySQL_pw = "1234";

	String id = request.getParameter("txtID");
	String pw = request.getParameter("txtPW");
	
//	System.out.println(id);		// 콘솔창에 출력
//	System.out.println(pw);
	
	if (id.equals(mySQL_id)) {
		if(pw.equals(mySQL_pw)){
			out.println(id + "님이 로그인 되었습니다.");
		} else{
			out.println("비밀번호를 확인해주세요.");
		}
	} else {
		out.println("아이디를 확인해주세요.");
	}

//	out.println(id);	// 브라우저에 출력
//	out.println(pw);
%>