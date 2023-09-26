package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, submit;
    Choice ctype,cloc;
    
    PickupService()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel title = new JLabel("Pickup Services");
        title.setFont(new Font("Tahoma",Font.BOLD,30));
        title.setBounds(400, 30, 300, 30);
        add(title);
        
        JLabel lbltype = new JLabel("Model of Car");
        lbltype.setBounds(80, 120, 150, 30);
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltype);
        
        ctype = new Choice();
        ctype.setBounds(240,120,150,30);
        ctype.setBackground(Color.white);
        add(ctype);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                ctype.add(rs.getString("model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel lblloc = new JLabel("Location of Driver");
        lblloc.setBounds(600, 120, 200, 30);
        lblloc.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblloc);
        
        cloc = new Choice();
        cloc.setBounds(800,120,150,30);
        cloc.setBackground(Color.white);
        add(cloc);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next())
            {
                cloc.add(rs.getString("location"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        JLabel lbl = new JLabel("Name");
        lbl.setBounds(40, 240, 100, 20);
        add(lbl);
        
        JLabel lbl1 = new JLabel("Age");
        lbl1.setBounds(170, 240, 100, 20);
        add(lbl1);
        
        JLabel lbl2 = new JLabel("Gender");
        lbl2.setBounds(290, 240, 100, 20);
        add(lbl2);
        
        JLabel lbl3 = new JLabel("Company");
        lbl3.setBounds(450, 240, 100, 20);
        add(lbl3);
        
        JLabel lbl4 = new JLabel("Model");
        lbl4.setBounds(590, 240, 100, 20);
        add(lbl4);
        
        JLabel lbl5 = new JLabel("Availability");
        lbl5.setBounds(720, 240, 100, 20);
        add(lbl5);
        
        JLabel lbl6 = new JLabel("Location");
        lbl6.setBounds(840, 240, 100, 20);
        add(lbl6);
        
        
        table = new JTable();
        table.setBounds(0, 270, 1000, 400);
        add(table);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(600,700,120,40);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,700,120,40);
        add(submit);
        
        setSize(1000, 800);
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
            String type = ctype.getSelectedItem();;
            String loc = cloc.getSelectedItem();
            
            try{
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from driver where model = '"+type+"' and location ='"+loc+"'");
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new PickupService();
    }
}
