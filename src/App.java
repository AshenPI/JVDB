import java.sql.*;
import java.util.*;
public class App {

    private static final String SQLInsert = "INSERT INTO SELLER (SELLER_NAME , EMAIL , POSTAL_ADDRESS) VALUES (? , ? ,?)";
    public static void main(String[] args) throws Exception {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB", "root", "101010");
        
            Statement stmt = con.createStatement();
            PreparedStatement prepStatement = con.prepareStatement(SQLInsert);
            try (Scanner myObj = new Scanner(System.in)) {
                System.out.println("insert seller name");
                String seller_name = myObj.nextLine();
                System.out.println("insert email ");
                String Email = myObj.nextLine();
                System.out.println("insert postal address name");
                String postal = myObj.nextLine();


                prepStatement.setString(1, seller_name);
                prepStatement.setString(2, Email);
                prepStatement.setString(3, postal);
            }
            int row = prepStatement.executeUpdate();

            String discount = "update product set price = price - (price * 0.15/100)where category_id = 05";
            String del = "Delete from product where availability = 'out of stock'";
            stmt.executeUpdate(discount);
            stmt.executeUpdate(del);
            
       
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
