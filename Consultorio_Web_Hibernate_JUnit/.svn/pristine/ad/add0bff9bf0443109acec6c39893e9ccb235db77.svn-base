<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tr>
	<td><label>*Nome do Paciente:</label></td>
	<td>
		<input type="text" name="nomePaciente" id="nome" class="required" value="${paciente.nome}" /> 
		<span>Informe seu nome completo</span><br/>
	</td>
</tr>
<tr>
	<td><label>*CPF:</label></td>
	<td>
		<input type="text" name="cpf" id="cpf" class="required cpf" value="${paciente.cpf}" /> 
		<span>Informe seu CPF</span>
	</td>
</tr>
<tr>
	<td>
		<label>*Data Nascimento:</label>
	</td>
	<td>
		<fmt:formatDate value="${paciente.dataNascimento}" type="date" pattern="dd/MM/yyyy" var="dataNascimento" />
		<input type="text" name="dataNascimento" id="dataNascimento" class="required data" maxlength="10" value="${dataNascimento}" /> <span>Informe sua data de nascimento</span>
	</td>
</tr>
<tr>
	<td>
		<label>*Email:</label>
	</td>
	<td>
		<input type="text" name="email" id="email" class="required email" value="${paciente.email }"/> 
		<span>Informe seu email</span>
	</td>
</tr>