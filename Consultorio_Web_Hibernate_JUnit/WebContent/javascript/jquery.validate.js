$.fn.extend({
	mascaraTel: function () {
				
		$(this).bind('focusin', function() {
			$(this).foneFocus();
		});
		
		$(this).bind('focusout', function() {
			$(this).foneFocusOut();
		});
		
	},
	
	foneFocusOut: function() {
		var phone, element, ddd;
		element = $(this);
		element.unmask();
		phone = element.val().replace(/\D/g, '');
		ddd = phone.substring(0, 2);
		if (phone.length > 10 && ddd == '11') {
			element.mask("(99) 99999-999?9", {
				placeholder : " "
			});
			element.unmask();
		} else {
			if (ddd != '11' && phone.length > 10) {
				element.val(element.val().substring(0,
						element.val().length - 1));
			}
			element.mask("(99) 9999-9999?9", {
				placeholder : " "
			});
			element.unmask();
		}
	}, 
	foneFocus: function() {
		$(this).unmask();
		$(this).mask("(99) 99999999?9", {placeholder : " "});
	}
});

function validarTel(){
	
	if($('#fone' + $('.fone').length).val() == ""){
		alert('Campo Telefone em branco. \nPreencha-o ante de adicionar um novo telefone');
		return false;
	}
	
	if($('#tipoTel' + $('.tipoTelefone').length).val() == "") {
		alert('Campo Tipo Telefone em branco. \nPreencha-o ante de adicionar um novo telefone');
		return false;
	}
	
	return true;
}
	

$.fn.extend({
	
	adicionaTel: function(){
		
		if(!validarTel())
			return;
		
		/* Pega uma linha existente */
		var linha = $('#repetir tr:first').html();

		var fone = $('.fone');
		var tipo = $('.tipoTelefone');
		linha = linha.replace("fone1", "fone" + (fone.length + 1));
		linha = linha.replace("tipoTel1", "tipoTel" + (tipo.length + 1));
		
		
		/* Acrescenta uma nova linha */
		$('#repetir').append('<tr>' + linha + '</tr>');
		
		$('.fone').mascaraTel();
		
		
	}	
});

$(document).ready(function() {
    $('.hide').hide();
    $('#show').click(function() {
            $('.hide').slideDown(1000);
            $('#show').hide(1000);
    });
});

$(document).ready(function(){
	
	$('#fone1').mascaraTel();
	
	$('button#addTel').click(function () {
		$(this).adicionaTel();
	});
	
	
	
});


//$(function() {
//
//	$('button#addTel').click(function() {
//		
//		if(($('#fone' + $('.fone').length).val())==""){
//			alert('Campo Telefone em braco. \nPreencha-o ante de adicionar um novo telefone');
//			return false;
//		}
//		
//		if(($('#tipoTelefone' + $('.tipoTelefone').length).val())=="") {
//			alert('Campo Tipo Telefone em braco. \nPreencha-o ante de adicionar um novo telefone');
//			return false;
//		}
//		
//		
//		/* Pega uma linha existente */
//		var linha = $('tbody#repetir tr').html();
//
//		/* Acrescenta uma nova linha */
//		$('tbody#repetir').append('<tr>' + linha + '</tr>');
//		
//		var fone = $('.fone');
//		var tipo = $('.tipoTelefone');
//		linha = linha.replace("fone" + fone.length, "fone" + (fone.length + 1));
//		linha = linha.replace("tipoTelefone" + tipo.length, "tipoTelefone" + (tipo.length + 1));
//		
//		//alert("tipoTelefone" + tipo.length).att("id");
//		$('.fone').mascaraTel();
//		 
//	});
//});


//$(function() {
//
//	$('button#addTel').click(function() {
//		
//		/* Pega uma linha existente */
//		var linha = $('tbody#repetir tr').html();
//
//		/* Acrescenta uma nova linha */
//		$('tbody#repetir').append('<tr>' + linha + '</tr>');
//				
//		$('.fone').mascaraTel();
//		
//	});
//});


/* Função jQuery para remover linha */
$.removeLinha = function (element)
{
	/* Conta quantidade de linhas na tabela */
	var linha_total = $('.tipoTelefone').length;
	/* Condição que mantém pelo menos uma linha na tabela */
	if (linha_total > 1)
	{
		/* Remove os elementos da linha onde está o botão clicado */
		$(element).parent().parent().remove();
	}
	/* Avisa usuário de que não pode remover a última linha */
	else
	{
		alert("Desculpe, mas você não pode remover esta última linha!");
	}
};

$.removeConsulta = function (element,valor)
{
	if (!confirm("Tem certeza que deseja excluir a consulta?")) {
		return false;
	}
	else{
		document.getElementById('cod_consulta').value = valor;
		$(element).parent().parent().remove();
	}
};


/* Quando o documento estiver carregado… 
$(document).ready(function()
{
	 Variável que armazena limite de linhas (zero é ilimitada) 
	var limite_linhas = 0;
	 Quando o botão adicionar for clicado... 
	$('#add').click(function()
	{
		 Conta quantidade de linhas na tabela 
		var linha_total = $('tbody#repetir tr').length;
		 Condição que verifica se existe limite de linhas e, se existir, testa se usuário atingiu limite 
		if (limite_linhas && limite_linhas > linha_total)
		{
			 Pega uma linha existente 
			var linha = $('tbody#repetir tr').html();
			 Conta quantidade de linhas na tabela 
			var linha_total = $('tbody#repetir tr').length;
			 Pega a ID da linha atual 
			var linha_id = $('tbody#repetir tr').attr('id');
			 Acrescenta uma nova linha, incluindo a nova ID da linha 
			$('tbody#repetir').append('<tr id="linha_' + (linha_total + 1) + '">' + linha + '</tr>');
		}
		 Se usuário atingiu limite de linhas… 
		else
		{
			alert("Desculpe, mas você só pode adicionar até " + limite_linhas + " linhas!");
		}
	});
});*/



try{
$(function() {
	
	$('.validate table span').hide();
    /* Required message */
    var requiredMsg = "Campo Requerido!";
    /* E-mail message */
    var mailMsg = "O e-mail informado é inválido!";
    /* CPF message */
    var cpfMsg = "CPF informado é inválido!";
    /* cnpj message */
    var cnpjMsg = "CNPJ informado  invlido!";
    /* Data message */
    var dataMsg = "Data informada é inválida!";    
    /* Numeric message */
    var dataValidadeMsg = "Data inválida!";
    /* Data Validade message */
    var numericMsg = "O valor deve ser númerico!";
    /* minlength message */
    var minMsg = "Informe ao menos X caracters!";
    /* maxlength message */
    var maxMsg = "A quantidade máxima é de X caracters!";
    /* Password message */
    var passwordMsg = "Senhas não conferem!";
    /* Telefone message */
    var foneMsg = "O telefone informado é inválido!";  
  
    
    
    /* mascaras */
    $('head').append('<script src="js/jquery.mask.js" type="text/javascript"></script>');
    /* mascara data */
    $('.data').mask('99/99/9999');
    /* mascara data validade */
    $('#dataValidade').mask('99/9999');
    $('#dataValidade2').mask('99/9999'); 
    /* mascara cpf */
    $('.cpf').mask('999.999.999-99');
    /* mascara cnpj */
    $('.cnpj').mask('99.999.999/9999-99');
    /* mascara placa */
    $('.placa').mask('aaa-9999');
    /* mascara telefone */
    //$('.fone').mask('(99)9999-9999'); 
    /* mascara cep */
    $('#cep').mask('99999-999'); 
    /* validate style - comentar alinha abaixo para omitir o style */
    $("#nome").keyup(function() {  
        var valor = $("#nome").val().replace(/[^a-z\u00C0-\u00ff A-Z ]+/g,'');  
        $("#nome").val(valor);
    });
	
    //$('head').append('<link href="css/validate.css" type="text/css" media="screen" rel="stylesheet" />');
    /* button style - comentar alinha abaixo para omitir o style do button */
    $('head').append('<link href="css/button.css" type="text/css" media="screen" rel="stylesheet" />');
    /* botao reset - limpa forms*/
    $('.reset').live('click',function(){
        $('form').attr('onsubmit','return false');
        $('form').find('*').val('');
        $('form').find('*').removeClass('invalid').removeClass('valid');
        $('form').find('span').fadeOut(10);
        return false;
    });
    /* Aplicando Placeholder com texto do SPAN */
    $(this).find('.required').each(function(){
        $(this).attr('placeholder',$(this).parent().find('span').html());
    });
    
	$('.submit').live('click',function(){
		$('body').find('form.validate').submit();
	});
    $('.validate').submit(function() {
        var valid = true;
       
        $(this).find('.required').each(function(i){
            /* required */
            if ( $(this).hasClass('required') && $.trim( $(this).val() ) == ""){
                $(this).removeClass('valid').addClass('invalid');
                $(this).focus();
                $(this).parent().find('span').html(requiredMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500);
                valid = false;
                return false;
            } 
            else
            {
                $(this).removeClass('invalid').addClass('valid');
                $(this).parent().find('span').fadeOut(500);
            }
            
            /*requerid fone*/
            if ( $(this).hasClass('required') && $(this).hasClass('fone') ){
            	if($.trim( $(this).val() ) == ""){
                $(this).removeClass('valid').addClass('invalid');
                $(this).focus();
                $(this).parent().find('span').html(foneMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500);
                valid = false;
                return false;
            	}
            } 
            else
            {
                $(this).removeClass('invalid').addClass('valid');
                $(this).parent().find('span').fadeOut(500);
            }
            
          
		
            /* minlength value */
            if ( $(this).attr('minlength') && $(this).hasClass('required') ){
                if($.trim($(this).val()).length < $(this).attr('minlength') ){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(minMsg.replace(/X/g,$(this).attr('minlength'))).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
                else{
                    $(this).parent().find('span').fadeOut(500);
                    $(this).removeClass('invalid').addClass('valid');
                }
            }
            
            /* numeric value */
            if ( $(this).hasClass('required') && $(this).hasClass('numeric') ){
                var nan = new RegExp(/(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/);
                if (!nan.test($.trim( $(this).val() ))){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).parent().find('span').html(numericMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    $(this).select();
                    valid = false;
                    return false;
                }
                else{
                    $(this).parent().find('span').fadeOut(500);
                    $(this).removeClass('invalid').addClass('valid');
                }
            }
		
            /* mail */
            if ( $.trim( $(this).val() ) == ""){
                $(this).removeClass('valid').addClass('invalid');
                $(this).focus();
                $(this).parent().find('span').html(requiredMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                valid = false;
                return false;
            }
            if ( $(this).hasClass('email') ){
                var er = new RegExp(/^[A-Za-z0-9_\-\.]+@[A-Za-z0-9_\-\.]{2,}\.[A-Za-z0-9]{2,}(\.[A-Za-z0-9])?/);
                if (!er.test($.trim( $(this).val() ))){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(mailMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
                else{
                    $(this).removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            } 
            
            /* data */
            if ( $.trim( $(this).val() ) == "" ){
                $(this).removeClass('valid').addClass('invalid');
                $(this).focus();
                $(this).parent().find('span').html(requiredMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                valid = false;
                return false;
            }
            if ( $(this).hasClass('data') ){
                
                var sdata = $(this).val();
                if(sdata.length!=10)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;   
                }
                var data        = sdata;
                var dia         = data.substr(0,2);
                var barra1      = data.substr(2,1);
                var mes         = data.substr(3,2);
                var barra2      = data.substr(5,1);
                var ano         = data.substr(6,4);
                if(data.length!=10||barra1!="/"||barra2!="/"||isNaN(dia)||isNaN(mes)||isNaN(ano)||dia>31||mes>12)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;            
                }
                if((mes==4||mes==6||mes==9||mes==11) && dia==31){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
                if(mes==2 && (dia>29||(dia==29 && ano%4!=0))){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
                if(ano < 1900)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }                
                else{
                    $(this).removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            } 
            
            /* data validade */          
            if ( $(this).hasClass('dataValidade') ){
            	                
                var sdata = $(this).val();
                if(sdata.length!=7)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataValidadeMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;   
                }
                var data = sdata;
            	var dataP = new Date();
        		var mesAtual = dataP.getMonth() + 1;
        		var anoAtual = dataP.getFullYear();
                var mes = data.substr(0,2);
                var ano = data.substr(3,5);
               
                if ((mes < 1) || (mes > 12) || (ano < anoAtual)){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataValidadeMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
               
                if (ano == 2013 && mes < mesAtual)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataValidadeMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }                
                else{
                    $(this).removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            } 
            
            /* data validade2 */
            if ( $.trim( $(this).val() ) == ""){
                $(this).removeClass('valid').addClass('invalid');
                $(this).focus();
                $(this).parent().find('span').html(requiredMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                valid = false;
                return false;
            } 
            if ( $(this).hasClass('dataValidade2') ){
                
                var sdata = $(this).val();
                if(sdata.length!=7)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataValidadeMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;   
                }
                var data        = sdata;
            	var dataP = new Date();
        		var mesAtual = dataP.getMonth() + 1;
        		var anoAtual = dataP.getFullYear();
                var mes         = data.substr(0,2);
                var ano         = data.substr(3,5);
               
                if ((mes < 1) || (mes > 12) || (ano < anoAtual)){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataValidadeMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
               
                if (ano == 2013 && mes < mesAtual)
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(dataValidadeMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }                
                else{
                    $(this).removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            } 
            
            
               
            
            
            /* cpf */
       
            if ( $(this).hasClass('cpf') ){
                var cpf = $(this).val().replace('.','');
                cpf = cpf.replace('.','');
                cpf = cpf.replace('-','');
                while(cpf.length < 11) cpf = "0"+ cpf;
                var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
                var a = [];
                var b = new Number;
                var c = 11;
                for (i=0; i<11; i++){
                    a[i] = cpf.charAt(i);
                    if (i < 9) b += (a[i] * --c);
                }
                if ((x = b % 11) < 2) {
                    a[9] = 0;
                } else {
                    a[9] = 11-x;
                }
                b = 0;
                c = 11;
                for (y=0; y<10; y++) b += (a[y] * c--);
                if ((x = b % 11) < 2) {
                    a[10] = 0;
                } else {
                    a[10] = 11-x;
                }
                if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg))
                {
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(cpfMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
                else{
                    $(this).removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            } 
            
                     
            
            
            /*valida cnpj*/
            if($(this).hasClass('cnpj'))
            {
                var cnpj = $(this).val();
                cnpj = cnpj.replace('.','');
                cnpj = cnpj.replace('.','');
                cnpj = cnpj.replace('/','');
                cnpj = cnpj.replace('-','');
                var a = new Array();
                var b = new Number;
                var c = [6,5,4,3,2,9,8,7,6,5,4,3,2];
                for (i=0; i<12; i++){
                    a[i] = cnpj.charAt(i);
                    b += a[i] * c[i+1];
                }
                if ((x = b % 11) < 2) {
                    a[12] = 0
                } else {
                    a[12] = 11-x
                }
                b = 0;
                for (y=0; y<13; y++) {
                    b += (a[y] * c[y]);
                }
                if ((x = b % 11) < 2) {
                    a[13] = 0;
                } else {
                    a[13] = 11-x;
                }
                if ((cnpj.charAt(12) != a[12]) || (cnpj.charAt(13) != a[13])){
                    
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(cnpjMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);                    
                    valid = false;
                    return false;
                }
                else
                {
                    $(this).removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            }
		
            /* maxlength value */
            if ( $(this).attr('maxlength')  && $(this).hasClass('required') ){
                if($.trim($(this).val()).length > $(this).attr('maxlength') ){
                    $(this).removeClass('valid').addClass('invalid');
                    $(this).select();
                    $(this).parent().find('span').html(maxMsg.replace(/X/g,$(this).attr('maxlength'))).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);			
                    valid = false;
                    return false;
                }
                else{
                    $(this).parent().find('span').html('').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    $(this).removeClass('invalid').addClass('valid');
                }
            }	
	
            /* password */
            if ( $(this).hasClass('password') && $(this).parent().parent().find('.password').hasClass('password')){ 
                
                if ($.trim( $(this).val() ) != $.trim( $(this).parent().parent().find('.password').val() )){
                    $(this).parent().find('.password').removeClass('valid').addClass('invalid');
                    $(this).parent().find('.password').focus();
                    $(this).parent().find('span').html(passwordMsg).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    valid = false;
                    return false;
                }
                else{ 
                    $(this).parent().find('span').html('').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
                    $(this).nextAll('.password').removeClass('invalid').addClass('valid');
                    $(this).parent().find('.password').removeClass('invalid').addClass('valid');
                    $(this).parent().parent().find('.password').removeClass('invalid').addClass('valid');
                    $(this).parent().find('span').fadeOut(500);
                }
            }

        });
        return valid;
    });
});
}catch(err){alert("error in "+err.description);}


			
			
			
			/*$('#fone1').focus(function() {
				$(this).unmask();
				$(this).mask("(99) 99999999?9", {placeholder : " "});
				if ($(this).mask().length <= 2) {
				}}).focusout(function() {
						var phone, element, ddd;
						element = $(this);
						element.unmask();
						phone = element.val().replace(/\D/g, '');
						ddd = phone.substring(0, 2);
						if (phone.length > 10 && ddd == '11') {
							element.mask("(99) 99999-999?9", {
								placeholder : " "
							});
							element.unmask();
						} else {
							if (ddd != '11' && phone.length > 10) {
								element.val(element.val().substring(0,
										element.val().length - 1));
							}
							element.mask("(99) 9999-9999?9", {
								placeholder : " "
							});
							element.unmask();
						}
					});*/
	



/*$(document).ready(
		function() {
			$("#cpfCliente").ready(function () {
				var cpf = $("#cpfCliente").val();
				var cpfFormat = "";
				for(var i=0; i<=11; i++){
					cpfFormat+=cpf.charAt(i);
					if(i==2 || i==5){
						cpfFormat+=".";
					}
					if(i==8){
						cpfFormat+="-";
				  }
				}
				$("#cpfCliente").val(cpfFormat);	
		});
		
	});*/