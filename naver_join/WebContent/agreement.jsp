<%@page import="com.yks.agreement.AgreementClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<String> agr1 = AgreementClass.agr1();
	ArrayList<String> agr2 = AgreementClass.agr2();
	ArrayList<String> agr3 = AgreementClass.agr3();
	String line = null;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv=charset="UTF-8">
<title>네이버 약관 동의</title>
</head>
<body>
	<img alt="naver_logo" src="./img/naver_logo.PNG" height="90"> <br /><br />
	<input type="checkbox" name="agree1" /> 네이버 이용 약관 동의 (필수) <br />
	<textarea rows="5" cols="60" readonly="readonly" style="resize: none;">
	<%
		for (int i = 0; i < agr1.size(); i++){
			line = agr1.get(i);
			out.println(line);
		}
	%>
	</textarea>
	<br /><br />
	<input type="checkbox" name="agree2" /> 개인정보 수집 및 이용에 대한 안내 (필수) <br />
	<textarea rows="5" cols="60" readonly="readonly" style="resize: none;">
	<%
		for (int i = 0; i < agr2.size(); i++){
			line = agr2.get(i);
			out.println(line);
		}
	%>
	</textarea>
	<br /><br />
	<input type="checkbox" name="agree3" /> 위치정보 이용 약관 동의 (선택) <br />
	<textarea rows="5" cols="60" readonly="readonly" style="resize: none;">
	<%
		for (int i = 0; i < agr3.size(); i++){
			line = agr3.get(i);
			out.println(line);
		}
	%>
	</textarea>
	<br /><br />
	<input type="checkbox" name="agree4" /> 이벤트 등 프로모션 알림 메일 수신 (선택) <br />
	<br />
	<input type="button" value="취소" style="border: 0; width: 218px; height: 80px;" />
	<input type="button" value="확인" style="border: 1; width: 218px; height: 80px;" onclick="location.href='join_form.jsp'" />

</body>
</html>