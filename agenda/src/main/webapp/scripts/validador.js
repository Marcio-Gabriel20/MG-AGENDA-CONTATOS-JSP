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
	 		 let inputFone = document.querySelector('.inpFone');
	 
	 		 inputNome.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
	 		 inputFone.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
			 
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
			 
			 let inputNome = document.querySelector('.inpNome');
	 		 let inputFone = document.querySelector('.inpFone');
	 
	 		 inputNome.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
	 		 inputFone.style.cssText = 'border-bottom: 2px solid aqua; transition: 2s;';
			 
		 }, 4000);
		 
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