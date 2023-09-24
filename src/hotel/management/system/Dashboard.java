
package hotel.management.system;
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame{
    Dashboard()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1600,1000);
        setLocationRelativeTo(null);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds((dim.width-1600)/2,0, 1600, 1000); //(1920-1600)/2
        add(image);
        
        JLabel name = new JLabel("Welcome to hotel xyz");
        name.setBounds( 500, 120, 800, 100);
        name.setForeground(Color.darkGray);
        name.setFont(new Font("serif", Font.BOLD,70));
        image.add(name);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1600, 30);
        //mb.setBackground(Color.LIGHT_GRAY);
        image.add(mb);
        
        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.black);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("Reception");
        hotel.add(reception);
        
        JMenu admin = new JMenu("Admin");
        hotel.setForeground(Color.black);
        mb.add(admin);
        
        JMenuItem employee = new JMenuItem("Add Employee");
        admin.add(employee);
        
        JMenuItem room = new JMenuItem("Add Rooms");
        admin.add(room);
        
        JMenuItem driver = new JMenuItem("Add drivers");
        admin.add(driver);
        
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Dashboard();
    }
}
