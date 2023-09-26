package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    CustomerInfo()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel lbl = new JLabel("ID Type");
        lbl.setBounds(40, 10, 100, 20);
        add(lbl);
        
        JLabel lbl1 = new JLabel("ID");
        lbl1.setBounds(170, 10, 100, 20);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Name");
        lbl2.setBounds(290, 10, 100, 20);
        add(lbl2);
        
        JLabel lbl3 = new JLabel("Gender");
        lbl3.setBounds(400, 10, 100, 20);
        add(lbl3);
        
        JLabel lbl4 = new JLabel("Country");
        lbl4.setBounds(540, 10, 100, 20);
        add(lbl4);
        
        JLabel lbl5 = new JLabel("Room No");
        lbl5.setBounds(670, 10, 100, 20);
        add(lbl5);
        
        JLabel lbl6 = new JLabel("Date & Time");
        lbl6.setBounds(790, 10, 100, 20);
        add(lbl6);
        
        JLabel lbl7 = new JLabel("Price");
        lbl7.setBounds(910, 10, 100, 20);
        add(lbl7);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(400,500,120,30);
        add(back);
        
        setSize(1000, 600);
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
        new CustomerInfo();
    }
}
