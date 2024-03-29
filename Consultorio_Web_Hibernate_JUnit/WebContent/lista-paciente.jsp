<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="Pagina para busca de paciente" name="titulo"/>
</jsp:include>

<div id="container">
	
	<form id="f1" name="form" method="post" action="control" class="validate">
		<table>
			<tr>
				<td colspan=2>
					<br/><h2>Veja os dados dos Pacientes</h2>
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<br/><font color="blue">Selecone o campo pelo qual deseja fazer a pesquisa:</font><br/><br/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="opcao" value="cpf" onclick="habilitaCpf()"> CPF<br/>
				</td>
				<td>
					<input type="text" name="cpfBusca" id="cpfBusca" disabled="disabled" class=""/> 
					<span>Campo requerido, informe um CPF v&aacute;lido</span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="opcao" value="nome" onclick="habilitaNome()"> Nome<br/>
				</td>
				<td>
					<input type="text" name="nome" id="nomeBusca" disabled="disabled" class=""/> 
					<span>Campo requerido, informe o nome completo</span>
				</td>
			</tr>
			<tr>				
				<td>
					<br/><br/>
					<input class="button blue" type="submit" id="botao" onclick="mudaAction();" value="Buscar Paciente">
					<br/>
				</td>
				<td>
					<input type="hidden" name="logica" value="PacienteController">
				</td>
				<td>
					<input type="hidden" name="action" id="actionId" value="Lista">
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<br/><br/>
					<h3 align="center">${mensagem }</h3>
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>