package JAVAproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Java_Steps 
{
    public static void main(String[] args) 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
            System.out.println("Connection established\n");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from customer");
            while(rs.next()) 
            {
                int id = rs.getInt("CustID");
                String name = rs.getString("Cust_Name");
                String city = rs.getString("Cust_City");
                System.out.println("Customer ID = "+id+"\nCustomer Name = "+name+"\nCustomer City = "+city);
                System.out.println("");
            }
            con.close();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Class Not Found");
        }
        catch(SQLException e) 
        {
            System.out.println("SQL Exception "+ e.getMessage());
        }
    }
}
