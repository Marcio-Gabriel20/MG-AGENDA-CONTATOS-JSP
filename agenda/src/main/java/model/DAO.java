package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// Executar a query

			pst.executeUpdate();

			// Encerrando a conexão com o banco de dados

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
