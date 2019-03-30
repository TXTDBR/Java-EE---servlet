<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
</head>
<body>
<c:import url="../../cabecalho.jsp"/>
<%-- comentário em JSP aqui :Jstl --%>
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de Nascimento</th>
			<th>Ações</th>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.id}</td>
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
			<td><a href="mvc?logica=RemoverContatoLogica&id=${contato.id}">Remover</a>|
			<a href="mvc?logica=BuscarContatoLogica&id=${contato.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="../../rodape.jsp"/>
</body>
</html>