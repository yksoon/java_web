<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	
	String mySQL_id = "root";
	String mySQL_pw = "1234";

	String id = request.getParameter("txtID");
	String pw = request.getParameter("txtPW");
	
//	System.out.println(id);		// �ܼ�â�� ���
//	System.out.println(pw);
	
	if (id.equals(mySQL_id)) {
		if(pw.equals(mySQL_pw)){
			out.println(id + "���� �α��� �Ǿ����ϴ�.");
		} else{
			out.println("��й�ȣ�� Ȯ�����ּ���.");
		}
	} else {
		out.println("���̵� Ȯ�����ּ���.");
	}

//	out.println(id);	// �������� ���
//	out.println(pw);
%>