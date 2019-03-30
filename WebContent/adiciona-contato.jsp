<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link href="jquery/jquery-ui.min.css" rel="stylesheet"/>
	<link href="jquery/jquery-ui.theme.min.css" rel="stylesheet"/>
	<script src="jquery/external/jquery/jquery.js"></script>
	<script src="jquery/jquery-ui.min.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<form	action="mvc">
	'	<input type="hidden" name="logica" value="AdicionarContatoLogica"/>
		Nome:	<input	type="text"	name="nome"	/><br	/>
		E-mail:	<input	type="text"	name="email"	/><br	/>
		Endereço:	<input	type="text"	name="endereco"	/><br	/>
		Data de Nascimento:	<caelum:campoData id="dataNascimento"/><br	/>
		<input	type="submit" 	value="Gravar"	/>
	</form>

<c:import url="rodape.jsp"/>
</body>
</html>