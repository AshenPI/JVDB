import java.sql.*;
import java.util.*;
public class App2 {
    public static void main(String[] args) throws Exception {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db2", "root", "101010");
        
            Statement stmt = con.createStatement();
           
       
       
             ResultSet rs = stmt.executeQuery("select * from seller");
         
            while (rs.next())
                System.out.println("\n" + rs.getString(1) + "  " +
                 rs.getString(2) + "  " + 
                 rs.getString(3) +"  " 
               
                
                 
                 );
                 
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
