
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;
    
    UpdateCheck()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90, 20, 200, 20);
        add(text);
        
        JLabel lblid = new JLabel("Customer id");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                customer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room No");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblcheckin = new JLabel("Check-In");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount Paid");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblpaid.setBounds(30, 240, 100, 20);
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Amount Pending");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblpending.setBounds(30, 280, 100, 20);
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);
        
        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setBounds(30,320,75,25);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(135,320,75,25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(230,320,75,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setSize(980,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==check){
            String id = customer.getSelectedItem();
            
            try {
                Conn c = new Conn();
                String query = "select * from customer where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkin"));
                    tfpaid.setText(rs.getString("deposit"));
                    tfpending.setText(rs.getString("deposit"));   
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '"+tfroom.getText()+"'");
                while(rs2.next())
                {
                    String temp = rs2.getString("price");
                    int temp_ = Integer.parseInt(temp);
                    int temp__ = Integer.parseInt(tfpending.getText());
                    temp_ -=temp__;
                    tfpending.setText(Integer.toString(temp_));
                }
            } catch (Exception e) {
                e.printStackTrace();
                //Logger.getLogger(UpdateCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(ae.getSource()==update){
            String number = customer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"',name = '"+name+"', checkin = '"+checkin+"', deposit = '"+deposit+"'");
                JOptionPane.showMessageDialog(null, "Data Updated!");
                setVisible(false);
            new Reception();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args)
    {
        new UpdateCheck();
    }
}
