import java.sql.*;
import java.util.*;

public class App2 {
    public static void main(String[] args) throws Exception {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db2", "root", "101010");
        
            Statement stmt = con.createStatement();
           
            String recursive = "WITH RECURSIVE supervisor_list AS (SELECT emp_name, supervisor_id FROM employee_supervisor WHERE emp_name = 'Ali' UNION ALL SELECT e.emp_name, e.supervisor_id FROM employee_supervisor e JOIN supervisor_list s ON e.emp_id = s.supervisor_id) SELECT emp_name FROM supervisor_list;";
       
           
            ResultSet rs =  stmt.executeQuery(recursive);
         
            while (rs.next())
                System.out.println("\n" + rs.getString(1)
               
                
                 
                 );
                 
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
