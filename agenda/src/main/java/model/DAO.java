package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "root";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
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

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {

		String create = "insert into contatos (nome,fone,email) values (?,?,?)";

		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, contato.getNome().replaceAll("\s+", " "));
			pst.setString(2, contato.getFone().replaceAll("\s+", " "));
			pst.setString(3, contato.getEmail().replaceAll("\s+", " "));

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "select * from contatos order by id";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new JavaBeans(id, nome, fone, email));

			}

			con.close();

			return contatos;

		} catch (Exception e) {

			System.out.println(e);
			return null;

		}

	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {

		String read2 = "select * from contatos where id = ?";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

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

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {

		String update = "update contatos set nome=?,fone=?,email=? where id=?";

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome().replaceAll("\s+", " "));
			pst.setString(2, contato.getFone().replaceAll("\s+", " "));
			pst.setString(3, contato.getEmail().replaceAll("\s+", " "));
			pst.setString(4, contato.getId().replaceAll("\s+", " "));
			pst.executeUpdate();

			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
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

}
