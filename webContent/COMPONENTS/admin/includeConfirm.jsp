<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    
      <%!
// Basic declarations
String DRIVER = "com.mysql.jdbc.Driver";
String URL = "jdbc:mysql://localhost:3306/testezvous";
String USERNAME = "root";
String PASSWORD = "";
java.sql.Connection conn1,conn2;
java.sql.Statement st1;
java.sql.ResultSet rec1;
%>
 
<%
String id=request.getParameter("id");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testezvous");
Statement st=conn.createStatement();
Statement st1=conn.createStatement();
int i=st.executeUpdate("DELETE FROM quiz WHERE id="+id);
int j=st1.executeUpdate("DELETE FROM question WHERE idQuiz="+id);
response.sendRedirect("confirm.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
									
									
									
									
 