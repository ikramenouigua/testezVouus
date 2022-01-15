package testez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc1 {
	
	public static void main(String[] args) throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String con="jdbc:mysql://localhost:3308/testez vous";
	
	    
		
		
		String req = "insert into usertable(email,password,role) values('houda@gmail.com','jouhar123','etudiant'); ";
		try {
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(con, "root" ,"");
		System.out.println("connected succesfully");
		PreparedStatement st=conn.prepareStatement(req);
		st.executeUpdate();
		System.out.println("insertion effectue avec succes");
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
	}

}
