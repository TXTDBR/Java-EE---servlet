<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
</head>
<body>

<%-- comentário em JSP aqui :Jstl --%>
	<table border='1'>
	
		<jsp:useBean id="dao" class="br.com.caleum.dao.JdbcTarefaDao"/>
		<c:import url="cabecalho.jsp"/>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
		</tr>
		<c:forEach var="contato" items="${dao.getList()}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				<td>
				<c:choose>
				<c:when test="${not empty contato.email }">
					<a href="mailto:${contato.email}">${contato.email }</a>
				</c:when>
				<c:otherwise>
					E-mail não informado.
				</c:otherwise>
				</c:choose>
				
				</td>
				<td>${contato.endereco}</td>
				
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp"/>
</body>
</html>