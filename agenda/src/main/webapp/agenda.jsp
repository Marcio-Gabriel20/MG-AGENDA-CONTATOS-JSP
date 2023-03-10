<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%

	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/agenda.css">
<link rel="icon" href="imgs/ctt.png">
<script src="https://kit.fontawesome.com/4ad013ec14.js" crossorigin="anonymous"></script>
<title>Agenda de Contatos</title>
</head>
<body>

	<div id="back">
		<div id="acesso">
			<h1>Agenda de Contatos</h1>
			<a href="novo-ctt.html" class="btnNovoCtt">Novo Contato</a>
			<div id="scroll">
				<% for (int i = 0; i < lista.size(); i++) {%>
				
					<div id="divCtt">
						
						<div id="idNome">
							<p id="id"><%= lista.get(i).getId() %></p>
							<p id="nome"><%= lista.get(i).getNome() %></p>
						</div>
						<a href="select?id=<%= lista.get(i).getId() %>" class="btn btnEditar"><i class="fa-solid fa-pen-to-square"></i></a>
						<a href="" class="btn btnExcluir"><i class="fa-solid fa-trash"></i></a>
					
					</div>
					<div id="divDados">
					
						<div id="divFone">
						
							<p id="fone"><%= lista.get(i).getFone() %></p>
						
						</div>
						<div id="divEmail">
							<p id="email"><%= lista.get(i).getEmail() %></p>
						</div>
					
					</div>
				
				<%} %>
			</div>
		</div>
	</div>

</body>
</html>