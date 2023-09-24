/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
//import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author Sabarish
 */
public class HotelManagementSystem extends JFrame{

    HotelManagementSystem()
    {
        setSize(1366,565);
        setLocationRelativeTo(null);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
        image.setBounds(0, 0, 1366, 565);
        
        JLabel text = new JLabel("Hotel Mmgt System");
        text.setBounds(20, 430, 800, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.BOLD,70));
        image.add(text);
        
        JButton button = new JButton("Enter");
        button.setBounds(1100,430, 200, 70);
        button.setBackground(Color.red);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("serif", Font.BOLD,38));
        image.add(button);
        
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new HotelManagementSystem();
    }
    
}
