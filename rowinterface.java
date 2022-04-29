package ppp;
import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.RowSet;
public class rowinterface 
{
    public static void main(String[] args)
    {
        try
        {
            //driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            RowSet rowset = new JdbcRowSetImpl();
            rowset.setUrl("jdbc:mysql://localhost:3306/project"); 
            rowset.setUsername("root");
            rowset.setPassword("");
            rowset.setCommand("select Id,Name, Email,Phone,address from mytable123");
            rowset.execute();
            while(rowset.next())
            {
                System.out.println("Id = "+rowset.getInt("Id"));
                System.out.println("Name = "+rowset.getString("Name"));
                System.out.println("Email = "+rowset.getString("Email"));
                System.out.println("Phone = "+rowset.getString("Phone"));
                System.out.println("Address ="+rowset.getString("Address"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
    
    

