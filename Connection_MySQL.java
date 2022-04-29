package JAVAproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connection_MySQL 
{
    public static void main(String[] args)
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded.");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
            System.out.println("Connection Established.");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }
}
