/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Sabarish
 */
public class Login extends JFrame implements ActionListener {
    
    JButton button1, button;
    JTextField usertf,pwtf;
    
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,20);
        add(user);
        
        usertf = new JTextField();
        usertf.setBounds(150,20, 100,20);
        add(usertf);
        
        JLabel pw = new JLabel("Password");
        pw.setBounds(40,45,100,20);
        add(pw);
        
        pwtf = new JTextField();
        pwtf.setBounds(150,45, 100,20);
        add(pwtf);
        
        
        button = new JButton("Login");
        button.setBounds(40,70, 100, 30);
        button.setBackground(Color.red);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("serif", Font.BOLD,17));
        button.addActionListener(this);
        add(button);
        
        button1 = new JButton("Cancel");
        button1.setBounds(150,70, 100, 30);
        button1.setBackground(Color.red);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("serif", Font.BOLD,17));
        button1.addActionListener(this);
        add(button1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        
        setSize(700,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==button){
            String u = usertf.getText();
            String p = pwtf.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+u+"' and password = '"+p+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or pw!!!");
                    setVisible(false);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==button1){
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Login();
    }
}
