<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
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
	String filename = (String) session.getAttribute("file_name"),
	filepath = (String) session.getAttribute("file_path");
	
	// execute the command and get object of Process class to denote
	// this command
	Process process = Runtime.getRuntime().exec
	("javac \""+filepath+filename+".java"+"\"");
	
	// get error related data from the process
	InputStream error = process.getErrorStream();
	
	String errorData = "";
	
	while(true)
	{
		int i = error.read();
		
		if(i == -1)
		{
			break;
		}
		
		errorData = errorData + (char) i;
	}
	
	//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>"+errorData.length());
	
	if(errorData.isEmpty())
	{
%>
	<h3 style="color: blue;">
		Compilation Successfull, to run<a href="run.jsp"> click here</a>
	</h3>
<%
	}
	else
	{  errorData=errorData.substring(115);
%>
	<h4 style="color: red;">
		<%=errorData%>
	</h4>
<%
	}
%>	
</body>
</html>