package utilis;
import java.sql.*;

public class DBCon {

	// JDBC driver name and database URL
   	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost/project";

   	//  Database credentials
   	static final String USER = "root";
   	static final String PASS = "adir1234";
	
	public static Connection  con;
	public static Statement   stmt;

	
	static void open(){
		try {
			//Register JDBC driver
      			Class.forName(JDBC_DRIVER);
	    	  	//Open a connection
      			con = DriverManager.getConnection(DB_URL,USER,PASS);
			//create query statement
	          	stmt= con.createStatement();   
	      	}catch (Exception e){   
	    	  	System.out.println(e);   
	      	}
	}
	
	 static void close() throws SQLException{
		 // Close connection
		 stmt.close();                    
	     con.close();
	 } 
	 
	 public static int login(String name, String pass) throws SQLException{
		 open();
		 String  str;
		 str= "SELECT  *  FROM users WHERE username = "+"'"+name+"' and pass='"+pass+"'"   ;
		 ResultSet  rs = stmt.executeQuery(str); // הרצה של השאילתה והכנסת הנתונים לאובייקט 
		 if(rs.next()){
			close();
			return 1;
		 }
		 else{
			close();
			return 0;
		 }
		
	}
	 public static boolean register(String username,String fname,String lname, String pass) throws SQLException{
		 open();
		 String  str;
		 str= "insert into users Values('"+username+"','"+fname+"','"+lname+"','"+pass+"')"   ;
		boolean ok = stmt.execute(str); // הרצה של השאילתה והכנסת הנתונים לאובייקט 
		return ok;
	}
}
