
package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class AddEmployee extends JFrame {
    
    AddEmployee()
    {
        setLayout(null);
//        setBounds(350,200,850,540);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblname);
        
        JTextField tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblage);
        
        JTextField tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblgender);
        
        JRadioButton rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahona", Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        JRadioButton rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 80, 30);
        rbfemale.setFont(new Font("Tahona", Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,540);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new AddEmployee();
    }
    
}
