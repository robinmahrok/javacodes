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
	String filename = (String) session.getAttribute("file_name")+".class",
	filepath = (String) session.getAttribute("file_path"),
	classname = filename.substring(0, filename.lastIndexOf("."));
	
	// execute the command and get object of Process class to denote
	// this command
	Process process = Runtime.getRuntime().exec
	("java  -cp \""+filepath+";\" "+classname);

	//System.out.println	("cmd /c start java  -cp \""+filepath+";\" "+classname);

	// get output related data from the process
	InputStream output = process.getInputStream();
	
	String outputData = "";
	
	while(true)
	{
		int i = output.read();
		
		if(i == -1)
		{
			break;
		}
		
		outputData = outputData + (char) i;
	}

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
	if (errorData=="")
	{
		errorData="No Error.";
	}
%>	
	<form>
		<i style="color : blue;">output</i><br>
		<textarea rows="6" cols="40"><%=outputData%></textarea><br>
		<i style="color : red;">error</i><br>
		<textarea rows="6" cols="40"><%=errorData%></textarea>
	</form>
</body>
</html>












