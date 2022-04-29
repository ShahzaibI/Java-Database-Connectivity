
package rowsetmetadat;
import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.*;
import java.io.*;
import java.sql.ResultSetMetaData;
public class rowsetmetadata {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            RowSet rowset = new JdbcRowSetImpl();
            rowset.setUrl("jdbc:mysql://localhost:3306/ppt");
            rowset.setUsername("root");
            rowset.setPassword("");
            rowset.setCommand("select id,name,Email from demodata");
            
            rowset.execute();
            
            
            while(rowset.next())
            {
                System.out.println("Id = "+rowset.getInt("Id"));
                System.out.println("Name = "+rowset.getString("name"));
                System.out.println("Email="+rowset.getString("Email"));
            }
           ResultSetMetaData obj = rowset.getMetaData();
           for(int i =1;i<=obj.getColumnCount();i++)
            {
                System.out.println("Name of colum "+i+" : "+obj.getColumnName(i));
                System.out.println("size of column is:"+obj.getColumnDisplaySize(i));
                System.out.println("type of coloumn and class:"+obj.getColumnClassName(i));
                System.out.println("type of column:"+obj.getColumnTypeName(i));
                System.out.println("table name:"+obj.getTableName(i));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
