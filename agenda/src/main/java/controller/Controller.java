package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {

			contatos(request, response);

		} else if (action.equals("/insert")) {

			novoContato(request, response);

		} else {
			
			response.sendRedirect("index.html");
			
		}

		// Teste de Conexão

		// dao.testeConexao();

	}

	// Listar contatos

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Criando um objeto que irá receber os dados JavaBeans
		
		ArrayList<JavaBeans> lista = dao.listarContatos();
		
		// Encaminhar a lista ao documento agenda.jsp
		
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
		
		// Teste de recebimento da lista
		
		/*for (int i = 0; i < lista.size(); i++) {
			
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
			System.out.println(lista.get(i).getEmail());
			
		}*/

	}
	
	// Novo contato

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// teste de recebimento dos dados do formulário
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("fone"));
		//System.out.println(request.getParameter("email"));
		
		// setar as variáveis JavaBeans
		
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		// invocar o método inserirContato passando o objeto contato
		
		dao.inserirContato(contato);
		
		// redirecionar para o documento agenda.jsp
		
		response.sendRedirect("main");

	}

}
