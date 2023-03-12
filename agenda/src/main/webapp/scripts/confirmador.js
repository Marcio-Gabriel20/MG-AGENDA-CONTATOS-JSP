/**
 * Confirmação de exclusão de um contato
 * 
 * @param id
 */

function confirmar(id) {

	let resposta = confirm("Confirmar a exclusão deste contato?");

	if(resposta === true) {
		
		window.location.href = "delete?id=" + id;
		
	}

} 