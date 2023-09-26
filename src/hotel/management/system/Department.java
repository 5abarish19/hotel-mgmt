package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Department()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel lbl = new JLabel("Department");
        lbl.setBounds(180, 10, 100, 20);
        add(lbl);
        
        JLabel lbl1 = new JLabel("Budget");
        lbl1.setBounds(370, 10, 100, 20);
        add(lbl1);
        
        
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        setSize(700, 480);
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
        new Department();
    }
}
