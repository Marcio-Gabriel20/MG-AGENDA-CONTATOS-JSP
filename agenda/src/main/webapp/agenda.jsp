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
<title>Agenda de Contatos</title>
</head>
<body>

	<div id="back">
		<div id="acesso">
			<h1>Agenda de Contatos</h1>
			<a href="novo-ctt.html">Novo Contato</a>
			<div id="scroll">
				<% for (int i = 0; i < lista.size(); i++) {%>
				
					<div id="divCtt">
						
						<p id="id"><%= lista.get(i).getId() %></p>
						<p id="nome"><%= lista.get(i).getNome() %></p>
					
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