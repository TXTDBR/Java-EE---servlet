<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- comentário em JSP aqui : nossa primeira page em JSP --%>
<%
	String mensagem = "Bem vindo ao sistema de agenda do fj21";
%>
<%	out.println(mensagem);	%>
<br>
<%
	String desenvolvido = "Desenvolvido	por	(Jean)";
%>

<% out.println(desenvolvido); %>

<% System.out.println("Tudo foi executado!"); %>
<br>
</body>
</html>