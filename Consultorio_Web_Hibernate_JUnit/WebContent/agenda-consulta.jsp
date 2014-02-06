<jsp:include page="header.jsp">
	<jsp:param value="Tela para Agendar Consulta" name="titulo"/>
</jsp:include>

<jsp:include page="formulario.jsp">
	<jsp:param value="ConsultaController" name="classe"/>
	<jsp:param value="${mensagem}" name="mensagem"/>
</jsp:include>

<jsp:include page="footer.jsp"></jsp:include> 



