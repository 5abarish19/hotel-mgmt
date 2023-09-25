
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    
    JTextField tfroomno,tfprice;
    JButton add,cancel;
    JComboBox cbavailable,cbcleaning,cbtype;
    
    AddRooms()
    {
        setLayout(null);
//        setBounds(350,200,850,540);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("Tahona", Font.BOLD,19));
        add(heading);
        
        JLabel lblroomno = new JLabel("Room no");
        lblroomno.setBounds(60,80,120,30);
        lblroomno.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblroomno);
        
        tfroomno = new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        add(tfroomno);
        
        JLabel lblavailable = new JLabel("Room Availability");
        lblavailable.setBounds(60,130,120,30);
        lblavailable.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblavailable);
        
        String AvailableOptions[] = {"Available","Occupied"};
        cbavailable = new JComboBox(AvailableOptions);
        cbavailable.setBounds(200,130,150,30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
        
        JLabel lblCleaning = new JLabel("Cleaning Status");
        lblCleaning.setBounds(60,180,120,30);
        lblCleaning.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblCleaning);
        
        String CleaningOptions[] = {"Clean","Dirty"};
        cbcleaning = new JComboBox(CleaningOptions);
        cbcleaning.setBounds(200,180,150,30);
        cbcleaning.setBackground(Color.white);
        add(cbcleaning);
        
        JLabel lblprice = new JLabel("Room Price");
        lblprice.setBounds(60,230,120,30);
        lblprice.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60,280,120,30);
        lbltype.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lbltype);
        
        String TypeOptions[] = {"Single","Double"};
        cbtype = new JComboBox(TypeOptions);
        cbtype.setBounds(200,280,150,30);
        cbtype.setBackground(Color.white);
        add(cbtype);
        
        add = new JButton("Add Room");
        add.setBounds(60,350,130, 30);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        //submit.setFont(new Font("serif", Font.BOLD,38));
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,130, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        //submit.setFont(new Font("serif", Font.BOLD,38));
        add(cancel);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,540);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add){
        String roomno = tfroomno.getText();
        String available = (String)cbavailable.getSelectedItem();
        String cleaning = (String)cbcleaning.getSelectedItem();
        String price = tfprice.getText();
        String type = (String)cbtype.getSelectedItem();
    
        /*
        Example Validation
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        */
        
        try{
            Conn c = new Conn();
            String query = "insert into room values('"+roomno+"','"+available+"','"+cleaning+"','"+price+"','"+type+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Room added!!");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }else if(ae.getSource()==cancel){
            setVisible(false);
    }
    }
    
    
    public static void main(String[] args)
    {
        new AddRooms();
    }
    
}
