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

	private static final String INSERT_USERS_SQL = "INSERT INTO quiz" + "  (sujet, description,niveau,emailuser,nbclic) VALUES "
			+ " (?, ?,? ,?,?);";
	private static final String select_QuizS_SQL = "SELECT ID FROM quiz where sujet =? and description=?";
	
	private static final String select_QuizS_byUser = "SELECT * FROM quiz where emailuser =? ";
	private static final String select_QuizS_All = "SELECT * FROM quiz  ";
	private static final String select_QuizS_byUser5 = "SELECT * FROM quiz where emailuser =? limit 5 ";
	private static final String select_Quiz_byId = "SELECT * FROM quiz where id =? ";
	private static final String delete_quiz_sql = "DELETE FROM quiz where id = ?";
	private static final String delete_question_sql = "DELETE FROM question where idQuiz = ?";
	private static final String select_Quiz_Chatbot = "SELECT * FROM quiz where sujet=? and niveau=? ";
	private static final String update_nbClic_sql = "update quiz set nbclic=nbclic+1 where id=?";
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
			preparedStatement.setInt(5, quiz.getNbclic());
			
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
	public boolean updateNbClic(int id) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(update_nbClic_sql);) {
			statement.setInt(1, id);
			
            System.out.println("update khdam");
			rowUpdated = statement.executeUpdate() > 0;
			System.out.println("update khdam2");
			System.out.println(rowUpdated);
		}
		return rowUpdated;
	}
	
	public Quiz selectQuiz(int id) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(select_Quiz_byId)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
			 
			Quiz quiz=new Quiz(rs.getString("sujet"),rs.getString("description"),rs.getString("niveau"),rs.getString("emailuser"),rs.getInt("nbclic")) ;
		    	return quiz;
			}
		
		} catch (SQLException e) {
			printSQLException(e);
		}
		return null; 
	}
	public List<Quiz> selectQuizChatbot(String sujet, String niveau) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Quiz> quizs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(select_Quiz_Chatbot);) {
			preparedStatement.setString(1, sujet);
			preparedStatement.setString(2, niveau);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String sujet1 = rs.getString("sujet");
				String description = rs.getString("description");
				String niveau1 = rs.getString("niveau");
				String emailuser = rs.getString("emailuser");
				quizs.add(new Quiz(id, sujet1, description, niveau1,emailuser,rs.getInt("nbclic")));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quizs;
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
				quizs.add(new Quiz(id, sujet, description, niveau,emailuser,rs.getInt("nbclic")));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quizs;
	}
	public int CountNBClic(String email) {
        int som=0;
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
			som+=rs.getInt("nbclic");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return som;
	}
	
	public List<Quiz> selectQuiz5(String email) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Quiz> quizs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(select_QuizS_byUser5);) {
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
				quizs.add(new Quiz(id, sujet, description, niveau,emailuser,rs.getInt("nbclic")));
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
				quizs.add(new Quiz(id, sujet, description, niveau,emailuser,rs.getInt("nbclic")));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quizs;
	}
	public boolean  deleteQuiz(int id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(delete_quiz_sql);
		System.out.println(delete_question_sql);
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(delete_question_sql);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(delete_quiz_sql);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		
		return rowDeleted;
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
