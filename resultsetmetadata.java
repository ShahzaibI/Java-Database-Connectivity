package met_dt;
import java.util.*;
import java.io.*;
import java.sql.*;
public class resultsetmetadata 
{
    public static void main(String[] args)
    {
        
        Connection con =null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");
            con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/ppt","root","");
            System.out.println("connection established");
            Statement st=con.createStatement();
            ResultSet result=st.executeQuery("select * from demoData");
            ResultSetMetaData metaData = result.getMetaData();//ResultSetMetaData is an interface exist in java.sql pkg
            System.out.println("Name of database: "+metaData.getCatalogName(1));
            for(int i =1;i<=metaData.getColumnCount();i++)
            {
                System.out.println("Name of colum "+i+" : "+metaData.getColumnName(i));
                System.out.println("size of column is:"+metaData.getColumnDisplaySize(i));
                System.out.println("type of coloumn and class:"+metaData.getColumnClassName(i));
                System.out.println("type of column:"+metaData.getColumnTypeName(i));
                System.out.println("table name:"+metaData.getTableName(i));
                
            }
            
            con.close();
        }
        catch(SQLException r)
        {
            System.out.println("found exception"+r.getMessage());
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Exception"+e.getMessage());
        }
    }
}
