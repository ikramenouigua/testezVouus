package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Quiz;
import model.User;

public class QuizDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/testezvous";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO quiz" + "  (sujet, description,niveau,emailuser) VALUES "
			+ " (?, ?,? ,?);";
	private static final String select_QuizS_SQL = "SELECT ID FROM quiz where sujet =? and description=?";
	
	private static final String select_QuizS_byUser = "SELECT * FROM quiz where emailuser =? ";
	private static final String select_QuizS_All = "SELECT * FROM quiz  ";

	

	public QuizDAO() {
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

	public void insertQuiz(Quiz quiz) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, quiz.getSujet());
			preparedStatement.setString(2, quiz.getDescription());
			preparedStatement.setString(3, quiz.getNiveau());
			preparedStatement.setString(4, quiz.getEmailuser());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public int searchQuiz(String sujet,String Desc) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		int id=0;
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(select_QuizS_SQL)) {
			preparedStatement.setString(1, sujet);
			preparedStatement.setString(2, Desc);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
			 id = rs.getInt("id");
				
			}
		
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id; 
	}
	
	public List<Quiz> selectQuiz(String email) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Quiz> quizs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(select_QuizS_byUser);) {
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String sujet = rs.getString("sujet");
				String description = rs.getString("description");
				String niveau = rs.getString("niveau");
				String emailuser = rs.getString("emailuser");
				quizs.add(new Quiz(id, sujet, description, niveau,emailuser));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quizs;
	}
	
	public List<Quiz> selectQuizAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Quiz> quizs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(select_QuizS_All);) {
			
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String sujet = rs.getString("sujet");
				String description = rs.getString("description");
				String niveau = rs.getString("niveau");
				String emailuser = rs.getString("emailuser");
				quizs.add(new Quiz(id, sujet, description, niveau,emailuser));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quizs;
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
