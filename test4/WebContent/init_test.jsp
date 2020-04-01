<%@page import="java.net.UnknownHostException"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.IOException, java.io.PrintWriter, java.io.FileWriter, java.util.GregorianCalendar, java.net.InetAddress" %>
<%!
private PrintWriter logFile;
public void jspInit(){
	String filename = "C:/filetest/datetime_log.txt";
	try{
		FileWriter fw = new FileWriter(filename, true);
		logFile = new PrintWriter(fw);
	} catch (IOException ioe) {
		System.out.printf("%TT - %s 파일을 열 수 없습니다.", new GregorianCalendar(), filename);
	}
}

private static String getIP(){
	
	String ip = null;
	
	try{
		ip = InetAddress.getLocalHost().getHostAddress();
	} catch (UnknownHostException u){
		
	}
	return ip;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	GregorianCalendar now = new GregorianCalendar();
	String date = String.format("현재날짜 : %TY년 %Tm월 %Te일", now, now, now);
	String time = String.format("현재시간 : %TI시 %Tm분 %TS초", now, now, now);
	
	
	out.println(date+"<br />");
	out.println(time+"<br />");
	out.println(getIP()+"<br />");
	if(logFile != null) {
		logFile.printf("%TF %TT에 호출되었습니다. %n", now, now);
		logFile.printf("ip주소 : %s", getIP());
	}
%>

</body>
</html>

<%!
public void jspDestroy(){
	if(logFile != null){
		logFile.close();
	}
}
%>