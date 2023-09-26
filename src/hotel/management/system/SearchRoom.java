package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    
    SearchRoom()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("Search for room");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(400, 30, 200, 30);
        add(heading);
        
        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(50, 100, 100, 20);
        add(bed);
        
        bedtype = new JComboBox(new String[] {"Single","Double"});
        bedtype.setBounds(150, 100, 150, 25);
        bedtype.setBackground(Color.white);
        add(bedtype);
        
        available  = new JCheckBox("Display only available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.white);
        add(available);
        
        JLabel lbl = new JLabel("Room No");
        lbl.setBounds(50, 160, 100, 20);
        add(lbl);
        
        JLabel lbl1 = new JLabel("Availability");
        lbl1.setBounds(270, 160, 100, 20);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Clean Status");
        lbl2.setBounds(450, 160, 100, 20);
        add(lbl2);
        
        JLabel lbl3 = new JLabel("Price");
        lbl3.setBounds(670, 160, 100, 20);
        add(lbl3);
        
        JLabel lbl4 = new JLabel("Room Type");
        lbl4.setBounds(870, 160, 100, 20);
        add(lbl4);
        
        table = new JTable();
        table.setBounds(0, 200, 1050, 300);
        add(table);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        setSize(1050, 700);
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
        else if(ae.getSource()==submit)
        {
            try{
                String query = "select * from room where type = '"+bedtype.getSelectedItem()+"'";
                String query1 = "select * from room where available = 'Available' AND type = '"+bedtype.getSelectedItem()+"'";
                
                Conn c = new Conn();
                ResultSet rs;
                if(available.isSelected())
                    rs = c.s.executeQuery(query1);
                else
                    rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new SearchRoom();
    }
}
