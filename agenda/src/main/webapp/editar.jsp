<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/editar.css">
<link rel="icon" href="imgs/ctt.png">
<script src="scripts/validador.js" defer></script>
<title>Agenda de Contatos - Novo Contato</title>
</head>
<body>

	<div id="back">
		<div id="acesso">
			<h1>Editar Contato</h1>
			<form name="frmContato" action="update">

				<div class="div id">
					<input type="text" name="id" id="inpId" readonly value=" <% out.print(request.getAttribute("id")); %> ">
				</div>

				<div class="div nome">
					<input type="text" name="nome" class="inpNome" value=" <% out.print(request.getAttribute("nome")); %> ">
				</div>

				<div class="div fone">
					<input type="tel" maxlength="15" name="fone"
						class="inpFone" id="inpFone" value=" <% out.print(request.getAttribute("fone")); %> ">
				</div>

				<div class="div email">
					<input type="text" name="email"
						class="inpEmail" value=" <% out.print(request.getAttribute("email")); %> ">
				</div>

				<div class="divMsgError">
					<p class="pMsgError"></p>
				</div>

				<input type="button" value="Salvar" class="btnAdd"
					onclick="validar()">

			</form>
		</div>
	</div>

</body>
</html>