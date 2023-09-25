
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JButton add,cancel;
    JComboBox cbgender,cbavailable;
    
    AddDriver()
    {
        setLayout(null);
//        setBounds(350,200,850,540);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(150,10,200,20);
        heading.setFont(new Font("Tahona", Font.BOLD,19));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,70,120,30);
        lblname.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,110,120,30);
        lblage.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,150,120,30);
        lblgender.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblgender);
        
        String GenderOptions[] = {"Male","Female"};
        cbgender = new JComboBox(GenderOptions);
        cbgender.setBounds(200,150,150,30);
        cbgender.setBackground(Color.white);
        add(cbgender);
        
        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setBounds(60,190,120,30);
        lblcompany.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setBounds(60,230,120,30);
        lblmodel.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Availablity");
        lblavailable.setBounds(60,270,120,30);
        lblavailable.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lblavailable);
        
        String AvailableOptions[] = {"Available","Occupied","On Leave"};
        cbavailable = new JComboBox(AvailableOptions);
        cbavailable.setBounds(200,270,150,30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(60,310,120,30);
        lbllocation.setFont(new Font("Tahona", Font.PLAIN,17));
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);
        
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
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(980,470);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add){
        String name = tfname.getText();
        String age = tfage.getText();
        String gender = (String)cbgender.getSelectedItem();
        String company = tfcompany.getText();
        String model = tfmodel.getText();
        String available = (String)cbavailable.getSelectedItem();
        String location = tflocation.getText();
    
        /*
        Example Validation
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
            return;
        }
        */
        
        try{
            Conn c = new Conn();
            String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Driver added!!");
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
        new AddDriver();
    }
    
}
