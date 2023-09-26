package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Room()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel lbl = new JLabel("Room No");
        lbl.setBounds(10, 10, 100, 20);
        add(lbl);
        
        JLabel lbl1 = new JLabel("Availability");
        lbl1.setBounds(110, 10, 100, 20);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Clean Status");
        lbl2.setBounds(210, 10, 100, 20);
        add(lbl2);
        
        JLabel lbl3 = new JLabel("Price");
        lbl3.setBounds(310, 10, 100, 20);
        add(lbl3);
        
        JLabel lbl4 = new JLabel("Room Type");
        lbl4.setBounds(410, 10, 100, 20);
        add(lbl4);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room order by roomno asc");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);
        
        setSize(1050, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args)
    {
        new Room();
    }
}
