package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox cbid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel lblcheckin;
    JButton add,cancel;
    
    AddCustomer()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);
        
        String idOptions[] = {"Aadhar","Passport","Drivers License","Voter ID", "Ration ID"};
        cbid = new JComboBox(idOptions);
        cbid.setBounds(200, 80, 150, 25);
        cbid.setBackground(Color.white);
        add(cbid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 200, 70, 30);
        rbmale.setFont(new Font("Tahona", Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 200, 80, 30);
        rbfemale.setFont(new Font("Tahona", Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel lblroom = new JLabel("Room No");
        lblroom.setBounds(35, 280, 100, 20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        
        croom = new Choice();
        
        try{
            Conn c = new Conn();
            String query = "select * from room";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                croom.add(rs.getString("roomno"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel lbltime = new JLabel("Check in");
        lbltime.setBounds(35, 320, 100, 20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
        
        Date date = new Date();
        
        lblcheckin = new JLabel(""+date);
        lblcheckin.setBounds(200, 320, 150, 25);
        lblcheckin.setFont(new Font("Raleway",Font.PLAIN,16));
        add(lblcheckin);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 360, 100, 20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add = new JButton("Add Customer");
        add.setBounds(35,400,130, 30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        //submit.setFont(new Font("serif", Font.BOLD,38));
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200,400,130, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        //submit.setFont(new Font("serif", Font.BOLD,38));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        
        setSize(800,550);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add){
            String id = (String)cbid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rbmale.isSelected())
                gender = "Male";
            else if(rbfemale.isSelected())
                gender = "Female";
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = lblcheckin.getText();
            String deposit = tfdeposit.getText();
            
            try{
            Conn c = new Conn();
            String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
            String query2 = "update room set available = 'Occupied' where roomno = '"+room+"'";
            c.s.executeUpdate(query);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Customer added!!");
            setVisible(false);
            new Reception();
            }catch(Exception e){
            e.printStackTrace();
            }
            
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }

    
}
