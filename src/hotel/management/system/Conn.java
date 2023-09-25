
package hotel.management.system;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;



public class Conn {
    
    Connection c;
    Statement s;
    
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","12345678");
            s = c.createStatement();
        } catch (Exception e) {
            //Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            e.printStackTrace();
        }
    }
    
}
