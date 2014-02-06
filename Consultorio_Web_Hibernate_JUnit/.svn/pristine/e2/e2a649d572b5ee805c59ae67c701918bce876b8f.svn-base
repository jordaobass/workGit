<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="consulta" class="control.ListaDataConsulta"/>


<div id="container">

	<form action="control" method="post" class="validate" id="f1">
		<br/>	
		<table>
			<tr>
				<td colspan=2>
					<h2>Agende uma Consulta</h2>
				</td>
			</tr>
			<tr>
				<td><br/>Cpf:</td>
				<td>
					<input name="cpf" class="required cpf" id="cpfBusca" value="${paciente.cpf}" id="cpfCliente" size="50" type="text" >
				</td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td>
					<input name="nome" value="${paciente.nome }" id="nome" size="50" type="text" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Data da Consulta:</td>
				<td>
					<select name="data">
						<c:forEach var="listaconsulta" items="${consulta.data}">
							<option  value="${listaconsulta}"> ${listaconsulta} </option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Tipo Consulta:</td>
				<td>
					<select name="TipoConsulta">
						<option value ="Sem Plano" >Sem Plano</option>
								<c:forEach var="listaPlanos" items="${paciente.planos}">
								<option  value="${listaPlanos.nome.label}"> ${listaPlanos.nome.label} </option>
							</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="actionId" name="action" value="lista"/>
					<input type="hidden" name="logica" value="${param.classe}"/>
				</td>
				<td>
					<button class="button blue" type="submit" onclick="muda('cadastrar')" >Cadastrar Consulta</button>
				</td>
				<td>
					<button class="button blue" type="submit" onclick="muda('lista')" >Lista</button>
				</td>
			</tr>
			<tr>
				<td colspan=3><br/><br/><h3 align="center"> ${param.mensagem}</h3></td>
			</tr>
		</table>
	</form>
</div>