package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame{
    
    JComboBox cbid;
    JTextField tfnumber,tfname,tfcountry;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel lblcheckin;
    
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
        
        
        setSize(800,550);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
