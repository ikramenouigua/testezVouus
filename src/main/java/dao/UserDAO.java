package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Quiz;
import model.User;

public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/testezvous";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO utilisateur " + "  (nom, email ,mot_de_passe ,role) VALUES "
			+ " (?, ?,? ,?);";
	private static final String select_QuizS_SQL = "SELECT * FROM utilisateur where email =? and mot_de_passe=?";
	private static final String select_user_SQL = "SELECT nom FROM utilisateur where email =? ";
	private static final String select_user_SQL1= "SELECT * FROM utilisateur where email =? ";
	private static final String Is_user_prof = "SELECT * FROM utilisateur where email =? and role=? ";

	

	public UserDAO() {
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

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getMot_de_passe());
			preparedStatement.setString(4, user.getRole());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public User se_connecter(String email,String mot_de_passe) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(select_QuizS_SQL)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, mot_de_passe);
			ResultSet rs = preparedStatement.executeQuery();
		    if(rs.next())
		    {
		    	User user=new User(rs.getString("nom"),rs.getString("email"),rs.getString("mot_de_passe"),rs.getString("role")) ;
		    	return user;
		    }
		    else
		    {
		    	
		    	
		    }
		    }catch(Exception e) {
		    	System.out.println(e.getMessage());
		    }
		    
			return null;
			
		
	}
	
	public boolean is_Prof(String email)throws SQLException{
		String prof="Professeur";
		try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(Is_user_prof)) {
	preparedStatement.setString(1, email);
	preparedStatement.setString(2, prof);
	
	ResultSet rs = preparedStatement.executeQuery();
    if(rs.next())
    {
    	return true;
    }
   
    }catch(Exception e) {
    	System.out.println(e.getMessage());
    }
    
	return false;
	}
	public User selectProf(String email)throws SQLException{
		
		try (Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(select_user_SQL1)) {
	preparedStatement.setString(1, email);
	
	
	ResultSet rs = preparedStatement.executeQuery();
    if(rs.next())
    {
    	User user=new User(rs.getString("nom"),rs.getString("email"),rs.getString("mot_de_passe"),rs.getString("role")) ;
    	return user;
    }
   
    }catch(Exception e) {
    	System.out.println(e.getMessage());
    }
    
	return null;
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
