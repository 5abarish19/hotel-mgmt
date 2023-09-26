
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    Choice customer;
    JLabel lblroomno,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    
    Checkout()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lblid = new JLabel("Customer id");
        lblid.setBounds(30, 80, 100, 30);
        add(lblid);
        
        JLabel lblroom = new JLabel("Room No");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
        lblroomno = new JLabel();
        lblroomno.setBounds(150, 130, 100, 30);
        add(lblroomno);
        
        JLabel lblcheckin = new JLabel("Check-In");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 150, 30);
        add(lblcheckintime);
        
        customer = new Choice();
        customer.setBounds(150, 80, 150, 25);
        add(customer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                customer.add(rs.getString("number"));
                lblroomno.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkin"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);
        
        
        
        JLabel lblcheckout = new JLabel("Check-Out");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(150, 230, 150, 30);
        add(lblcheckouttime);
        
        checkout = new JButton("Checkout");
        checkout.setForeground(Color.white);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(30,300,100,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(150,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350, 50, 400, 250);
        add(image1);
        
        setSize(800,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Reception();
        }else if(ae.getSource()== checkout)
        {
            String query1 = "delete from customer where number = '"+customer.getSelectedItem()+"'";
            String query2 = "update room set available = 'Available' where roomno = '"+lblroomno.getText()+"'";
            
            try{
                
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout Success!");
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String args[])
    {
        new Checkout();
    }
}
