/**
 * Validação de Formulário
 */
 
 function validar() {
	 
	 let nome = frmContato.nome.value;
	 let fone = frmContato.fone.value;
	 
	 if(nome === "" && fone != "") {
		 
		 let input = document.querySelector('.inpNome');
		 let pMsgError = document.querySelector('.pMsgError').innerHTML;
		 
		 pMsgError = "Preencha o campo 'Nome'.";
		 
		 if(document.querySelector('.pMsgError').innerHTML === "" || document.querySelector('.pMsgError').innerHTML != pMsgError) {
			 
			document.querySelector('.pMsgError').innerHTML = pMsgError;
			input.focus(); 
			 
		 }
		 
		 input.style.cssText = 'border-bottom: 2px solid red;';
		 
		 setTimeout(function() {
			 
			 let inputNome = document.querySelector('.inpNome');
	 
	 		 inputNome.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
			 
		 }, 4000);
		 
		 return false;
		 
	 } else if(fone === "" && nome != "") {
		 
		 let input = document.querySelector('.inpFone');
		 let pMsgError = document.querySelector('.pMsgError').innerHTML;
		 
		 pMsgError = "Preencha o campo 'Fone'.";
		 
		 if(document.querySelector('.pMsgError').innerHTML === "" || document.querySelector('.pMsgError').innerHTML != pMsgError) {
			 
			document.querySelector('.pMsgError').innerHTML = pMsgError;
			input.focus();
			 
		 }
		 
		 input.style.cssText = 'border-bottom: 2px solid red;';
		 
		 setTimeout(function() {
			 
	 		 let inputFone = document.querySelector('.inpFone');
	 
	 		 inputFone.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
			 
		 }, 4000);
		 
		 return false;
		 
	 } else if(nome === "" && fone === "") {
		 
		 let inputNome = document.querySelector('.inpNome');
	 	 let inputFone = document.querySelector('.inpFone');
		 let pMsgError = document.querySelector('.pMsgError').innerHTML;
		 
		 pMsgError = "Preencha o campo 'Nome' e o campo 'Celular'.";
		 
		 if(document.querySelector('.pMsgError').innerHTML === "" || document.querySelector('.pMsgError').innerHTML != pMsgError) {
			 
			document.querySelector('.pMsgError').innerHTML = pMsgError;
			inputNome.focus();
			 
		 }
		 		 
		 inputNome.style.cssText = 'border-bottom: 2px solid red;';
		 inputFone.style.cssText = 'border-bottom: 2px solid red;';
		 
		 setTimeout(function() {
			 
			 let inputNome = document.querySelector('.inpNome');
	 		 let inputFone = document.querySelector('.inpFone');
	 
	 		 inputNome.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
	 		 inputFone.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
			 
		 }, 4000);
		 
		 return false;
		 
	 } else {
		 
		 document.forms["frmContato"].submit();
		 
	 }
	 
 }
 
/* Mascara de Telefone */
 
function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execMascara()",1)
}

function execMascara(){
    v_obj.value=v_fun(v_obj.value)
}

function mascaraFone(fone){
    fone = fone.replace(/\D/g,""); //Remove tudo o que não é dígito
    fone = fone.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    fone = fone.replace(/(\d)(\d{4})$/,"$1-$2"); //Coloca hífen entre o quarto e o quinto dígitos
    return fone;
}

window.onload = function(){
	document.querySelector('.inpFone').onkeyup = function(){
		mascara( this, mascaraFone );
	}
}
 
 