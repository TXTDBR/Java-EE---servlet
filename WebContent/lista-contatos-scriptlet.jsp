<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,java.text.*,br.com.caleum.dao.JdbcTarefaDao, br.com.caleum.modelo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- comentário em JSP aqui :Scriptlet --%>
	<table border='1'>
	<%-- 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 ContatoDAO cdao = new ContatoDAO(); 
			List<Contato> contatos = cdao.getList();
	--%>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
		</tr>
	<%--
		for(Contato contato : contatos){
	
	<tr>
		<td><%=contato.getNome()%></td>
		<td><%=contato.getEmail() %></td>
		<td><%=contato.getEndereco()%></td>
		<td><%=new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime()) %>
	</tr>
	
		}
	--%>
	
	</table>

</body>
</html>