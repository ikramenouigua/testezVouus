package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.Quiz;

public class QuestionDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/testezvous";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO question" + "  (question, choix1,choix2,choix3,reponse,idQuiz) VALUES "
			+ " (?, ?, ?, ?, ?,?);";
	private static final String select_questions_SQL = "select * from question where idQuiz=?";

	

	public QuestionDAO() {
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

	public void insertQuestion(Question qst) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, qst.getQuestion());
			preparedStatement.setString(2, qst.getChoix1());
			preparedStatement.setString(3, qst.getChoix2());
			preparedStatement.setString(4, qst.getChoix3());
			preparedStatement.setString(5, qst.getReponse());
			preparedStatement.setInt(6, qst.getIdQuiz());
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Question> selectQuestions(int id) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Question> qsts = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(select_questions_SQL);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id1 = rs.getInt("id");
				String qst = rs.getString("question");
				String ch1 = rs.getString("choix1");
				String ch2 = rs.getString("choix2");
				String ch3 = rs.getString("choix3");
				String rep = rs.getString("reponse");
				qsts.add(new Question(id1, qst, ch1,ch2,ch3,rep));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return qsts;
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
