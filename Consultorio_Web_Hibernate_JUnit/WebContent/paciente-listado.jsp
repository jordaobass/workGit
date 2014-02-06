<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="header.jsp">
	<jsp:param value="Paciente encontrado" name="titulo" />
</jsp:include>
 
<jsp:useBean id="meubean" class="control.ListaDataConsulta"/>

<div id="container">
	<form id="f1" name="dados" class="validate" action="control" method="post">
		<br/><br/>
		<table>
			<tr>
				<td colspan=2>Dados Pessoais<hr/></td>
			</tr>
			<tr>
				<td><label>C&oacute;digo do Paciente:</label></td>
				<td>
					<input type="text" name="codigo" value="${paciente.codigo}" readonly="readonly" />
				</td>
			</tr>
			<jsp:include page="dados-pessoais.jsp"/>
		</table>
		<table id="repetir">
			<c:forEach var="listaTelefones" items="${paciente.telefones }">
				<tr>
					<td>
						<label id="telCss">Telefone:</label>
					</td>
					<td>
						<input type="text" value="${listaTelefones.numero}" id="fone1" name="numeroTel" />
					</td>
					<td>
						<select name="tipoTel" class="tipoTelefone" id="tipoTel1">
							<c:forEach items="${meubean.tiposTelefone}" var="tipo">
								<c:choose>
									<c:when test="${listaTelefones.tipo.label == tipo.label}">
										<option value="${tipo}" selected>${tipo.label}</option>
									</c:when>
									<c:otherwise>
										<option value="${tipo}">${tipo.label}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</td>
					<td>
						<button type="button" class="button red" value="Remover" id="remove" onclick="$.removeLinha(this);">Remover</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<td>
					<button class="button gray" type="button" value="Adicionar Telefone" id="addTel">Adicionar Telefone</button>
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<br/>Endere&ccedil;o<hr>
				</td>
			</tr>
			<tr>
				<td>
					<label>Cep:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.cep}" name="cep" class="required" id="cep"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Logradouro:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.rua}" name="rua" id="rua" maxlength="1000" />
				</td>
			</tr>
			<tr>
				<td>
					<label>N&uacute;mero:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.numero}" name="numero" maxlength="1000" class="required"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Complemento:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.complemento}" name="complemento" maxlength="1000" />
				</td>
			</tr>
			<tr>
				<td>
					<label>Bairro:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.bairro}" name="bairro" id="bairro"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Cidade:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.cidade}" name="cidade"  id="cidade"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>Estado:</label>
				</td>
				<td>
					<input type=text value="${paciente.endereco.estado}" name="estado" id="estado" />
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<br/>Plano<hr>
				</td>
			</tr>
			<c:forEach var="listaPlanos" items="${paciente.planos }">
			<tr>
				<td><label>Plano:</label></td>
				<td>
					<select name="nomePlano">
						<c:forEach var="nplano" items="${meubean.nomePlanos}">
							<c:choose>
								<c:when test="${listaPlanos.nome.label == nplano.label}">
										<option value="${nplano}" selected> ${nplano.label}</option>
								</c:when>
								<c:otherwise>
									<option value="${nplano}">${nplano.label}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="text" value='<fmt:formatDate value="${listaPlanos.dataValidade}" pattern="MM/yyyy"/>' name="dataValidade" />
				</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan=2>
					<br/>Consulta<hr>
				</td>
			</tr>
			<tr>
				<td>
					<label>Data pr&oacute;xima consulta:</label>
				</td>
				<td>
					<input type="text" value="${data}" id="consulta" name="consulta" disabled="disabled"/>
				</td>
				<td>
					<input type="button" class="button red" value="Desmarcar" id="desmarcar"  onclick="$.removeConsulta(this,'sem');"/>
				</td>				
			</tr>
			<tr>
				<td>
					<input type="hidden" name="cod_consultahidden" value="${consulta.codigo}"/>
				</td>
				<td>
					<input type="hidden" name="dataConsultahidden" value="${data}"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="logica" value="PacienteController">
					<input type="hidden" id="actionId" name="action" value="alterar"/>
					<input type="hidden" name="cod_consulta" id="cod_consulta" value="${consulta.codigo}"/>
				</td>
			</tr>
			<tr>
				<td>
					<button class="button blue" type="submit" onclick="muda('alterar')" >Alterar dados</button>
				</td>
				<td>
					<button class="button blue" type="submit" onclick="muda('excluir')" id="butExc">Excluir dados</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="footer.jsp" />