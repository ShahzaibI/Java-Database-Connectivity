package prectice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PreparedStatement_exp
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        try
        {
            //driver load
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            //create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
            System.out.println("Connection establishes successfully");
            //query
            String create_query ="insert into salesman (salesman_id,name,city,commission)values(?,?,?,?)";
            //creating object of PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(create_query);
            
            System.out.print("Enter salesman_id:");
            int id = in.nextInt();
            in.nextLine();
            System.out.print("Enter name:");
            String name = in.nextLine();
            System.out.print("Enter city:");
            String city = in.nextLine();
            System.out.print("Enter commission:");
            int commission = in.nextInt();
            System.out.println("Value successfuly get from user");
            
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, city);
            pstmt.setInt(4,commission);
            pstmt.executeUpdate();
            System.out.println("Data successfult inserted");
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
