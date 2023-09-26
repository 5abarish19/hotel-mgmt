package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    Reception(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JButton newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        JButton rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        add(rooms);
        
        JButton department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        add(department);
        
        JButton allEmployees = new JButton("All Employees");
        allEmployees.setBounds(10,150,200,30);
        allEmployees.setBackground(Color.black);
        allEmployees.setForeground(Color.white);
        add(allEmployees);
        
        JButton custInfo = new JButton("Customer Info");
        custInfo.setBounds(10,190,200,30);
        custInfo.setBackground(Color.black);
        custInfo.setForeground(Color.white);
        add(custInfo);
        
        JButton managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        add(managerInfo);
        
        JButton checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        add(checkout);
        
        JButton update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        add(update);
        
        JButton roomStatus = new JButton("Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.white);
        add(roomStatus);
        
        JButton pickupService = new JButton("Pickup Service");
        pickupService.setBounds(10,390,200,30);
        pickupService.setBackground(Color.black);
        pickupService.setForeground(Color.white);
        add(pickupService);
        
        JButton searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.black);
        searchRoom.setForeground(Color.white);
        add(searchRoom);
        
        JButton logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setSize(800,570);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("New Customer Form"))
            new AddCustomer();
    }
    
    public static void main(String[] args){
        new Reception();
    }
}
