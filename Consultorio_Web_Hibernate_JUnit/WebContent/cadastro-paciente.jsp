<jsp:include page="header.jsp">
	<jsp:param value="Cadastro de pacientes" name="titulo"/>
</jsp:include>

<jsp:include page="formulario-cadastra-altera.jsp">
	<jsp:param value="" name="cpf"/>
	<jsp:param value="" name="disable"/>
	<jsp:param value="cadastrar" name="action"/>
	<jsp:param value="PacienteController" name="classe"/>
</jsp:include>

<jsp:include page="footer.jsp"></jsp:include>