<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.yks.db.DBReadWriteClass, java.sql.ResultSet, java.sql.SQLException, com.yks.encode.ChangeEncoding"%>
<%
	DBReadWriteClass.connectMySQL();	// ����
	
	ResultSet rs = DBReadWriteClass.dataSelectAll();	// stu_table�� select ���
	
	//rs.next();	// ���� ������ ��ġ�� �̵�
	
	//System.out.println(rs.getString(1));	// ù��° �ʵ尪 ���
	//System.out.println(rs.getString(2));	// �ι�° �ʵ尪 ���
	//System.out.println(ChangeEncoding.toUnicode(rs.getString(3)));	// ����° �ʵ尪 ���
%>

<!DOCTYPE html>
<html>
	<head><title></title>
	<body>
		<table border = "1">
			<tr><th>�й�</th><th>�ֹι�ȣ</th><th>�̸�</th></tr>
			<%while(rs.next()){ %>
			<tr>
				<td><%=rs.getString(1) %></td>
				<td><%=rs.getString(2) %></td>
				<td><%=ChangeEncoding.toUnicode(rs.getString(3)) %></td>
			</tr>
			<%} %>
		</table>
	</body>
	</head>
</html>
