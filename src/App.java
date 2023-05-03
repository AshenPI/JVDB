import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB", "root", "101010");
        
            Statement stmt = con.createStatement();
            
            String discount = "update product set price = price - (price * 0.15/100)where category_id = 05";
            
             stmt.executeUpdate(discount);

             ResultSet rs = stmt.executeQuery("select * from product");
            while (rs.next())
                System.out.println(rs.getString(1) + "  " +
                 rs.getString(2) + "  " + 
                 rs.getString(3) +"  " +
                 rs.getString(4) + "  " +
                 rs.getString(5) + "  "
                 
                 );
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
