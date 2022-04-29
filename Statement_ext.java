package prectice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statement_ext
{
    public static void main(String[] args)
    {
        try
        {
            //driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully ");
            //create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
            System.out.println("Connection establishes successfully");
            
            Statement stmt = con.createStatement();
            String del_query = "delete from salesman  where name='Hamza'";
            stmt.execute(del_query);
            System.out.println("Data successfly deleted");
            ResultSet result = stmt.executeQuery("select * from salesman");
            while(result.next())
            {
                System.out.println("salesmen_id: "+result.getInt(1));
                System.out.println("name: "+result.getString(2));
                System.out.println("city: "+result.getString(3));
                System.out.println("commission: "+result.getInt(4));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}