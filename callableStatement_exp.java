package prectice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class callableStatement_exp
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
            while(true)
            {
                System.out.println("1. Insert Data");
                System.out.println("2. Show all data");
                System.out.println("3. Show specific data");
                System.out.println("4. Exit the program");
                System.out.print("Enter your choice:");
                int choice = in.nextInt();
                if(choice==1)
                {
                    CallableStatement cstmt = con.prepareCall("{call insertion(?,?,?,?)}");
                    System.out.print("Enter salesman_id:");
                    int id = in.nextInt();
                    in.nextLine();
                    System.out.print("Enter name:");
                    String name = in.nextLine();
                    System.out.print("Enter city:");
                    String city = in.nextLine();
                    System.out.print("Enter commission:");
                    int commission = in.nextInt();
                    
                    cstmt.setInt(1, id);
                    cstmt.setString(2, name);
                    cstmt.setString(3, city);
                    cstmt.setInt(4,commission);
                    cstmt.execute();
                    System.out.println("Data successfult inserted");
                }
                else if(choice==2)
                {
                    CallableStatement cstmt = con.prepareCall("{call getdata()}");
                    cstmt.execute();
                    ResultSet rs = cstmt.getResultSet();
                    while(rs.next())
                    {
                        System.out.println("salesmen_id: "+rs.getInt(1));
                        System.out.println("name: "+rs.getString(2));
                        System.out.println("city: "+rs.getString(3));
                        System.out.println("commission: "+rs.getInt(4));
                    }
                }
                else if(choice==3)
                {
                    CallableStatement cstmt = con.prepareCall("{call getdataOfPid(?)}");
                    System.out.print("Enter id of person which data you want:");
                    int pid = in.nextInt();
                    cstmt.setInt(1, pid);
                    boolean x = cstmt.execute();
                    ResultSet rs = cstmt.getResultSet();
                    
                    while(rs.next())
                    {
                        System.out.println("salesmen_id: "+rs.getInt(1));
                        System.out.println("name: "+rs.getString(2));
                        System.out.println("city: "+rs.getString(3));
                        System.out.println("commission: "+rs.getInt(4));
                    }
                }
                else
                {
                    System.out.println("Application terminated");
                    break;
                }
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}