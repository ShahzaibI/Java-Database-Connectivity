
package prectice;

import java.sql.*;


public class ResultSet_exp {
        public static void main(String[] args) {
    Connection con = null;
        try{
    Class.forName("com.mysql.cj.jdbc.Driver");
       System.out.println("Driver Loaded");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "");
       System.out.println("Connection Established");
       
    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE );
    ResultSet rs = st.executeQuery("SELECT * FROM demodata");
    while(rs.next())
    {
       System.out.println(rs.getInt("Id"));
       System.out.println(rs.getString("Email"));
       System.out.println(rs.getString("Name"));
       System.out.println(rs.getInt("Phone"));
    }
   
   rs.afterLast(); 
   while (rs.previous()) {
   System.out.println(rs.getString("NAME") + " " + rs.getInt("Id"));
}
   rs.last();
    System.out.println(rs.getInt("Id"));
    
     rs.absolute(3);
     rs.updateString("Name", "ZAEEM");
     rs.updateRow();
   System.out.println(rs.getInt("Id") + " "+ rs.getString("Name"));
    
   
   rs.beforeFirst();
     while(rs.next()){
     System.out.println(rs.getString("Name"));
     }
 
    con.close();
    }
    catch(ClassNotFoundException e){
        System.out.println("Exception " +e.getMessage());
    }   
    catch (SQLException e) {
        System.out.println("SQL Exception " +e.getMessage()); 
        }
 
    }
}
