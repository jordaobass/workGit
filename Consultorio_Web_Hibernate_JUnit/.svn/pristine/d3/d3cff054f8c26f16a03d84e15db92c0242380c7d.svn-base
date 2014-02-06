<div id="container">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:useBean id="meubean" class="control.ListaDataConsulta"></jsp:useBean>

	<input type="hidden" value="${paciente.telefones}" name="listaTel" />
	<div id="wrap">
		<h3 align="center">${mensagem }</h3>
		<form id="f1" name="dados" class="validate" action="control" method="post">
			<table>
				<tr>
					<td colspan=2><br /> <br /> <font color="blue">
						Preencha os campos para realizar o cadastro</font>
					</td>
				</tr>
				<tr>
					<td colspan=2>
						<font color="blue">Os campos com (*) s&atilde;o obrigat&oacute;rios</font> 
						<br/><br/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						Dados Pessoais<hr/>
					</td>
				</tr>
				<jsp:include page="dados-pessoais.jsp"/>
			</table>
			<table id="repetir">
				<tr>
					<td><label id="telCss">*Telefone</label></td>
					<td>
						<input type="text" name="numeroTel" class="required fone" id="fone1"/>
						<span>Informe seu telefone com DDD</span>
					</td>						
					<td>
						<select name="tipoTel" class="tipoTelefone" id="tipoTel1">
							<option value="">Tipo do Telefone</option>
							<c:forEach items="${meubean.tiposTelefone}" var="tipo">
								<option value="${tipo}">${tipo.label}</option>
							</c:forEach>
						</select>
					</td>
					 <td>
					 	<button type="button" class="button red" value="Remover" id="remove" onclick="$.removeLinha(this);">Remover</button>
					 </td>
				</tr>				
			</table>
			<table>
				<tr>
					<td>
						<button type="button" class="button gray" id="addTel">Adicionar Telefone</button>
					</td>
				</tr>
				<tr>
					<td>
						<label>*Cep:</label>
					</td>
					<td>
						<input class="required" type=text name="cep" id="cep" maxlength="9" /> <span>Informe seu CEP</span>
					</td>
				</tr>
				<tr>
					<td>
						<label>Logradouro:</label>
					</td>
					<td>
						<input type=text name="rua" id="rua" maxlength="1000"value="" />
					</td>
				</tr>
				<tr>
					<td>
						<label>*N&uacute;mero:</label>
					</td>
					<td>
						<input name="numero" type=text maxlength="1000"class="required" /> 
						<span>Informe o	n&uacute;mero de sua residencia</span>
					</td>
				</tr>
				<tr>
					<td>
						<label>Complemento:</label>
					</td>
					<td>
						<input name="complemento" type=text maxlength="1000"value="" />
					</td>
				</tr>
				<tr>
					<td>
						<label>Bairro:</label>
					</td>
					<td>
						<input name="bairro" id="bairro" type=text maxlength="1000" value="" />
					</td>
				</tr>
				<tr>
					<td>
						<label>Cidade:</label>
					</td>
					<td>
						<input name="cidade" id="cidade" type=text maxlength="1000" value="" />
					</td>
				</tr>
				<tr>
					<td>
						<label>Estado:</label>
					</td>
					<td>
						<input name="estado" id="estado" type=text maxlength="1000" value="" />
					</td>
				</tr>

				<tr>
					<td colspan=2>
						<br/>Plano<hr>
					</td>
				</tr>
				<tr>
					<td>
						<label>*Plano:</label>
					</td>
					<td>
						<select name="nomePlano" id="combo" class="required">
							<option value="">Selecione um item na lista</option>
							<c:forEach var="nplano" items="${meubean.nomePlanos}">
								<option value="${nplano}">${nplano.label}</option>
							</c:forEach>
						</select> 
						<span>Selecione um item</span>
					</td>
				</tr>
				<tr>
					<td>
						<label>*Data Validade:</label>
					</td>
					<td>
						<input name="dataValidade" id="dataValidade" type=text maxlength="1000" class="required"> 
						<span>Informe a data de validade da sua carteirinha</span>
					</td>
				</tr>
				<tr>
					<td>
						<button class="button gray" type="button" id="show">Inserir	mais um plano</button>
					</td>
				</tr>
				<tr>
					<td>
						<label class="hide">Plano:</label>
					</td>
					<td>
						<select class="hide" name="nomePlano" id="nomePlano">
							<option value="">Selecione um item na lista</option>
							<c:forEach var="nplano" items="${meubean.nomePlanos}">
								<option value="${nplano}">${nplano.label}</option>
							</c:forEach>
						</select> 
						<span>Selecione um item</span>
					</td>
				</tr>
				<tr>
					<td>
						<label class="hide">Data Validade</label>
					</td>
					<td>
						<input name="dataValidade" id="dataValidade2" class="hide" type=text maxlength="1000"> 
						<span>Informe a data de	validade da sua carteirinha</span>
					</td>
				</tr>
				<tr>
					<td>
						<br/>
						<input class="button blue" value="Cadastrar Paciente" id="fadeOut" type="submit" />
					</td>
					<td>
						<input type="hidden" name="logica" value="${param.classe}"/>
						<input type="hidden" name="action" value="cadastrar"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>