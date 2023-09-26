package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    ManagerInfo()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel lbl = new JLabel("Name");
        lbl.setBounds(40, 10, 100, 20);
        add(lbl);
        
        JLabel lbl1 = new JLabel("Age");
        lbl1.setBounds(170, 10, 100, 20);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Gender");
        lbl2.setBounds(290, 10, 100, 20);
        add(lbl2);
        
        JLabel lbl3 = new JLabel("Job");
        lbl3.setBounds(400, 10, 100, 20);
        add(lbl3);
        
        JLabel lbl4 = new JLabel("Salary");
        lbl4.setBounds(540, 10, 100, 20);
        add(lbl4);
        
        JLabel lbl5 = new JLabel("Phone");
        lbl5.setBounds(670, 10, 100, 20);
        add(lbl5);
        
        JLabel lbl6 = new JLabel("Email");
        lbl6.setBounds(790, 10, 100, 20);
        add(lbl6);
        
        JLabel lbl7 = new JLabel("Salary");
        lbl7.setBounds(910, 10, 100, 20);
        add(lbl7);
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job = 'Manager'");
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
        new ManagerInfo();
    }
}
