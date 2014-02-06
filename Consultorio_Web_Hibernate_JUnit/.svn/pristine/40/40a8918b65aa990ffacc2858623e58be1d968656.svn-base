function muda(valor){
		document.getElementById('actionId').value = valor;
	}

function habilitaNome() {
	{
		document.getElementById('nomeBusca').disabled = true;
		document.getElementById('cpfBusca').disabled = true;
		document.getElementById('cpfBusca').className = "";
		document.getElementById('nomeBusca').disabled = false;
		document.getElementById('nomeBusca').className = "required";
	}
}

function mudaAction(){
	if((document.getElementById('nomeBusca').disabled == true) && (document.getElementById('cpfBusca').disabled == true)){
			document.getElementById('botao').type = 'reset';
			alert("Escolha uma das opções!");
			
	}
	if(document.getElementById('nomeBusca').disabled == true && (document.getElementById('cpfBusca').disabled == false)){
		document.getElementById('botao').type = 'submit';
		document.getElementById('actionId').value = "lista";
	}
	else{
		document.getElementById('botao').type = 'submit';
		document.getElementById('actionId').value = "listaNome";
	}
}

function habilitaCpf() {
	{
		document.getElementById('nomeBusca').disabled = true;
		document.getElementById('nomeBusca').className = "";
		document.getElementById('cpfBusca').disabled = true;
		document.getElementById('cpfBusca').disabled = false;
		document.getElementById('cpfBusca').className = "required cpf";
	}
}

function verificaCep() {
	if (document.dados.cep.value == "")
		$(this).removeClass('valid').addClass('invalid');
	$(this).focus();
	$(this).parent().find('span').html(requiredMsg).fadeOut(500).fadeIn(500)
			.fadeOut(500).fadeIn(500);
	valid = false;
	return false;
}
$(document).ready(
		function() {
			// Preenche os campos na a��o "Blur" (mudar de campo)

			$("#cep").blur(

					function() {

						var cep = $("#cep").val().replace('-', '');
						if ($("#cep").val() == "") {
							$(this).removeClass('valid').addClass('invalid');
							$(this).focus();
							$(this).parent().find('span').html(
									"Campo Requerido!").fadeOut(500)
									.fadeIn(500).fadeOut(500).fadeIn(500);
							valid = false;
							return false;
						}
						$("#rua").val("Pesquisando logradouro...");
						$("#bairro").val("Pesquisando bairro...");
						$("#cidade").val("Pesquisando cidade...");
						$("#estado").val("Pesquisando estado...");

						// seta a variavel requisitada no campo cep

						// Realiza a consulta
						/*
						 * Realiza a consulta atrav�s do toolsweb passando o cep
						 * como parametro e informando que vamos consultar no
						 * tipo javascript
						 */
						$.getScript(
								"http://www.toolsweb.com.br/webservice/clienteWebService.php?cep="
										+ cep + "&formato=javascript",
								function() {

									// unescape - Decodifica uma string
									// codificada com o m�todo escape.
									rua = unescape(resultadoCEP.logradouro);
									bairro = unescape(resultadoCEP.bairro);
									cidade = unescape(resultadoCEP.cidade);
									estado = unescape(resultadoCEP.estado);

									// preenche os campos
									$("#rua").val(rua);
									$("#bairro").val(bairro);
									$("#cidade").val(cidade);
									$("#estado").val(estado);

								});
					});
		});

$(document).ready(function() {
	$("#cpfBusca").mask("999.999.999-99");
	$("#cpfBusca").blur(function() {
		var myCPF;
		myCPF = $("#cpfBusca").val().replace('.', '').replace('.', '').replace('-', '');
		var numeros, digitos, soma, i, resultado, digitos_iguais;
		digitos_iguais = 1;
		if (myCPF.length < 11) {
			$(this).parent().find('span').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500);
			$('span').hide();
			$("#cpfBusca").focus();
			return false;
		}
		for (i = 0; i < myCPF.length - 1; i++)
			if (myCPF.charAt(i) != myCPF.charAt(i + 1)) {
				digitos_iguais = 0;
				break;
			}
			if (!digitos_iguais) {
				numeros = myCPF.substring(0, 9);
				digitos = myCPF.substring(9);
				soma = 0;
				for (i = 10; i > 1; i--)
					soma += numeros.charAt(10 - i)* i;
					resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
					if (resultado != digitos.charAt(0)) {
						$(this).parent().find('span').html(cpfMsg).fadeOut(500)
								.fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500);
						$(this).parent().find('span').html();
						$("#cpfBusca").focus();
						return false;
					}
					numeros = myCPF.substring(0, 10);
					soma = 0;
					for (i = 11; i > 1; i--)
						soma += numeros.charAt(11 - i)* i;
					resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
					if (resultado != digitos.charAt(1)) {
						$(this).parent().find('span').html(cpfMsg).fadeOut(500)
								.fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500);
						$(this).parent().find('span').html();
						$("#cpfBusca").focus();
						return false;
					}
				return true;
			} else {
				$(this).parent().find('span').html(cpfMsg).fadeOut(500)
					.fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500);
				$(this).parent().find('span').html();
				$("#cpfBusca").focus();
				return false;
			}
	});
});

$(document).ready(function() {
	$("#dataValidade").mask("99/9999");
	$("#dataValidade").blur(function() {
		var data = new Date();
		var mesAtual = data.getMonth() + 1;
		var anoAtual = data.getFullYear();
		var mes = $("#dataValidade").val().substr(0, 2);
		var ano = $("#dataValidade").val().substr(3, 5);

		if ((mes < 1) || (mes > 12) || (ano < anoAtual)) {
			alert("Data Inválida");
			$("#dataValidade").focus();
			return false;
		}
		if (ano == 2013 && mes < mesAtual) {
			alert("Mes inválido");
			$("#dataValidade").focus();

		} else {
			return true;
		}

	});
});

$(document).ready(function() {
	$("#dataValidade2").mask("99/9999");
	$("#dataValidade2").blur(function() {
		var data = new Date();
		var mesAtual = data.getMonth() + 1;
		var anoAtual = data.getFullYear();
		var mes = $("#dataValidade2").val().substr(0, 2);
		var ano = $("#dataValidade2").val().substr(3, 5);

		if ((mes < 1) || (mes > 12) || (ano < anoAtual)) {
			alert("Data Inválida");
			$("#dataValidade2").focus();
			return false;
		}
		if (ano == 2013 && mes < mesAtual) {
			alert("Mes inválido");
			$("#dataValidade").focus();

		} else {
			return true;
		}
	});
});

$(document).ready(function() {
	$("#butExc").click(function() {
	if (!confirm("Tem certeza que deseja excluir o cadastro?")) {
			// $("#butExc").submit();
			return false;
		}
	})

//	$("#desmarcar").click(function() {
//	if (!confirm("Tem certeza que deseja excluir a consulta?")) {
//			// $("#butExc").submit();
//			return false;
//		}
//	else{
//		remove();
//	}
//
//})
});





//
// $(document).ready(function() {
// $("#telefoneResidencial").mask("(99) 9999-9999");
// });
//
// $(document).ready(function() {
// $("#dataValidade").mask("99/9999");
// $("#dataValidade").blur(function() {
// var mes = $("#dataValidade").val().substr(0, 2);
// var ano = $("#dataValidade").val().substr(3, 5);
//
// if ((mes < 1) || (mes > 12) || (ano < 2013)) {
// alert("Data Inválida");
// $("#dataValidade").focus();
// // return false;
// } else
// return true;
// });
// });
//
// $(document).ready(function() {
// $("#dataValidade2").mask("99/9999");
// $("#dataValidade2").blur(function() {
// var mes = $("#dataValidade2").val().substr(0, 2);
// var ano = $("#dataValidade2").val().substr(3, 5);
//
// if ((mes < 1) || (mes > 12) || (ano < 2013)) {
// alert("Data Inválida");
// $("#dataValidade2").focus();
// // return false;
// } else
// return true;
//
// });
// });
//
// $(document).ready(function() {
// $("#dataNascimento").mask("99/99/9999");
// $("#dataNascimento").blur(function() {
// var dia = $("#dataNascimento").val().substr(0, 2);
// var mes = $("#dataNascimento").val().substr(3, 2);
// var ano = $("#dataNascimento").val().substr(6, 4);
// var data = new Date();
// var anoAtual = data.getFullYear();
//
// if (ano < 1900 || ano > anoAtual) {
// alert("Ano Inválido");
// $("#dataNascimento").focus();
// return false;
// }
//
// switch (mes) {
// case '01':
// if (dia <= 31)
// return (true);
// break;
// case '02':
// if (dia <= 29)
// return (true);
// break;
// case '03':
// if (dia <= 31)
// return (true);
// break;
// case '04':
// if (dia <= 30)
// return (true);
// break;
// case '05':
// if (dia <= 31)
// return (true);
// break;
// case '06':
// if (dia <= 30)
// return (true);
// break;
// case '07':
// if (dia <= 31)
// return (true);
// break;
// case '08':
// if (dia <= 31)
// return (true);
// break;
// case '09':
// if (dia <= 30)
// return (true);
// break;
// case '10':
// if (dia <= 31)
// return (true);
// break;
// case '11':
// if (dia <= 30)
// return (true);
// break;
// case '12':
// if (dia <= 31)
// return (true);
// break;
// }
// {
// alert("Data Inválida");
// $("#dataNascimento").focus();
// return false;
// }
// return true;
//
// });
// });
// $(document).ready(function() {
// $("#telefoneCelular").mask("(99) 9999-9999");
// });
// $(document).ready(function() {
// $("#telefoneComercial").mask("(99) 9999-9999");
// });
// $(document)
// .ready(
// function() {
// var mes = $("#dataVal").val().substr(0, 2);
// var ano = $("#dataVal").val().substr(3, 5);
// var decisao;
// var data = new Date();
// var mesAtual = data.getMonth() + 1;
// var anoAtual = data.getFullYear();
//
// if (anoAtual > ano) {
// decisao = confirm("O ano de validade do seu plano está vencido. Deseja marcar
// a consulta sem plano?");
// if (decisao)
// alert("Marque sua consulta...");
// else
// window.open("index.jsp");
// return false;
// }
// if (anoAtual == ano) {
// if (mesAtual > mes) {
// decisao = confirm("O mes de validade do seu plano está vencido. Deseja marcar
// a consulta sem plano?");
// if (decisao)
// alert("Marque sua consulta...");
// else
// window.open("index.jsp");
// return false;
// }
// }
// return true;
// });
