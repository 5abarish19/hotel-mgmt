
package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField tfroom,tfavailable,tfclean,tfpaid,tfpending;
    JButton check,update,back;
    JLabel tfroom1;
    
    UpdateRoom()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30, 20, 250, 30);
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
        
//        tfroom = new JTextField();
//        tfroom.setBounds(200,120,150,25);
//        add(tfroom);

        tfroom1 = new JLabel();
        tfroom1.setBounds(200,120,150,25);
        add(tfroom1);
        
        JLabel lblavailable = new JLabel("Availability");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblavailable.setBounds(30, 160, 100, 20);
        add(lblavailable);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,160,150,25);
        add(tfavailable);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblclean.setBounds(30, 200, 100, 20);
        add(lblclean);
        
        tfclean = new JTextField();
        tfclean.setBounds(200,200,150,25);
        add(tfclean);
        
        
        check = new JButton("Check");
        check.setForeground(Color.white);
        check.setBackground(Color.black);
        check.setBounds(30,300,75,25);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.black);
        update.setBounds(135,300,75,25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.setBounds(230,300,75,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setSize(980,450);
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
                    tfroom1.setText(rs.getString("room"));
                    tfavailable.setText(rs.getString("name"));
                    tfclean.setText(rs.getString("checkin"));
                       
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomno = '"+tfroom1.getText()+"'");
                while(rs2.next())
                {
                    tfavailable.setText(rs2.getString("available"));
                    tfclean.setText(rs2.getString("cleaning"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                //Logger.getLogger(UpdateCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(ae.getSource()==update){
            //String number = customer.getSelectedItem();
            String room = tfroom1.getText();
            String available = tfavailable.getText();
            String clean = tfclean.getText();
        
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set available = '"+available+"', cleaning = '"+clean+"' where roomno = '"+room+"'");
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
        new UpdateRoom();
    }
}
