package JAVAproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connection_Oracle 
{
    public static void main(String[] args)
    {
        Connection con = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded.");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Haider2001");
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
