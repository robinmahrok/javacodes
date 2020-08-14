<%@page import="java.io.FileOutputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String java_file_name = request.getParameter("filename"),
	source_code = request.getParameter("code");
	// get root folder of my application
	String root = application.getRealPath("/");
	//System.out.print(root+"\n"+java_file_name);
	// create a file and store the data inside this file
	new FileOutputStream(root+"\\"+java_file_name+".java").write(source_code.getBytes());
	// store the path inside session
	session.setAttribute("file_name", java_file_name);
	session.setAttribute("file_path", root);
	
	response.sendRedirect("compile.jsp");
%>
</body>
</html>