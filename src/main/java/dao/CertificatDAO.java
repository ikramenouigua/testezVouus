package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Certificat;
import model.Quiz;


public class CertificatDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/testezvous";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_CERTIFICATS_SQL = "INSERT INTO CERTIFICAT " + "  (sujet ,niveau_quiz ,idQuiz, emailuser) VALUES "
			+ " (?, ?,? ,?);";
	private static final String SELECT_CERTIFICATS_SQL = "SELECT CERTIFICAT.id,CERTIFICAT.sujet,CERTIFICAT.niveau_quiz,CERTIFICAT.idQuiz,CERTIFICAT.emailuser from CERTIFICAT ,QUIZ WHERE CERTIFICAT.idQuiz=QUIZ.id and QUIZ.emailuser=?"; 
	private static final String SELECT_CERTIFICATS_SQL1 = "SELECT * FROM CERTIFICAT WHERE emailuser= ?";

	public CertificatDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public List<Certificat> selectCertificat(String email) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Certificat> certs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CERTIFICATS_SQL);) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String sujet = rs.getString("sujet");
				String niveau = rs.getString("niveau_quiz");
				int idQ = rs.getInt("idQuiz");
				String emailuser = rs.getString("emailuser");
				certs.add(new Certificat(id, sujet, niveau, idQ,emailuser));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return certs;
	}
	
	public List<Certificat> selectCertificat1(String email) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Certificat> certs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CERTIFICATS_SQL1);) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String sujet = rs.getString("sujet");
				String niveau = rs.getString("niveau_quiz");
				int idQ = rs.getInt("idQuiz");
				String emailuser = rs.getString("emailuser");
				certs.add(new Certificat(id, sujet, niveau, idQ,emailuser));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return certs;
	}

	public void insertCertificat(Certificat certificat) throws SQLException {
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CERTIFICATS_SQL)) {
			preparedStatement.setString(1, certificat.getSujet());
			preparedStatement.setString(2, certificat.getNiveau_quiz());
			preparedStatement.setInt(3, certificat.getIdQuiz());
			preparedStatement.setString(4, certificat.getEmailuser());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
