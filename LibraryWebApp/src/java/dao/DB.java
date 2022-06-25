package dao;
import java.sql.*;

// Метод связи с базой данных
public class DB {
    public static Connection getCon() throws ClassNotFoundException{
	Connection con=null;
	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?user=webstudent"
                            + "&password=webstudent&serverTimezone=UTC"); 
	} catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    return con;
}     
}