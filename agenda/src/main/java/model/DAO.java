package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	/** Módulo de Conexão **/
	// Parâmetros de Conexão

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// Método de Conexão

	private Connection conectar() {

		Connection con = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {

			System.out.println(e);
			return null;

		}

	}

	/* CRUD CREATE */

	public void inserirContato(JavaBeans contato) {

		String create = "insert into contatos (nome,fone,email) values (?,?,?)";

		try {

			// abrir a conexão com o banco de dados

			Connection con = conectar();

			// Preparar a query para execução no banco de dados

			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os parâmetros pelo (?) conteúdo das variáveis JavaBeans

			pst.setString(1, contato.getNome().replaceAll("\s+"," "));
			pst.setString(2, contato.getFone().replaceAll("\s+"," "));
			pst.setString(3, contato.getEmail().replaceAll("\s+"," "));

			// Executar a query

			pst.executeUpdate();

			// Encerrando a conexão com o banco de dados

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	/* CRUD READ */

	public ArrayList<JavaBeans> listarContatos() {

		// Criando um objeto para acessar a classe JavaBeans

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select * from contatos order by id";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// o while abaixo será executado enquanto houver contatos

			while (rs.next()) {

				// variáveis de apoio que recebem os dados do banco

				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				// populando o ArrayList
					
				contatos.add(new JavaBeans(id, nome, fone, email));

			}

			con.close();

			return contatos;

		} catch (Exception e) {

			System.out.println(e);
			return null;

		}

	}
	
	/* CRUD UPDATE */
	
	// selecionar o contato
	
	public void selecionarContato(JavaBeans contato) {
		
		String read2 = "select * from contatos where id = ?";
		
		try {
			
			Connection con = conectar();			
			PreparedStatement pst = con.prepareStatement(read2);			
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
				
			}
			
			con.close();
			
		} catch (Exception e) {

			System.out.println(e);
			
		}
		
	}
	
	// Editar Contato
	
	public void alterarContato(JavaBeans contato) {
		
		String update = "update contatos set nome=?,fone=?,email=? where id=?";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);			
			pst.setString(1, contato.getNome().replaceAll("\s+"," "));
			pst.setString(2, contato.getFone().replaceAll("\s+"," "));
			pst.setString(3, contato.getEmail().replaceAll("\s+"," "));
			pst.setString(4, contato.getId().replaceAll("\s+"," "));
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
	}
	
	/* CRUD DELETE */
	
	public void deletarContato(JavaBeans contato) {
		
		String delete = "delete from contatos where id=?";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {

			System.out.println(e);
			
		}
		
	}

	// Teste de Conexão

	/*
	 * public void testeConexao() {
	 * 
	 * try {
	 * 
	 * Connection con = conectar(); System.out.println(con); con.close();
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println(e);
	 * 
	 * }
	 * 
	 * }
	 */

}
