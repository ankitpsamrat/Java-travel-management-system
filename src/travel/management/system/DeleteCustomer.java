package travel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener {
    JButton b1, b2;
    String username;

    DeleteCustomer( String user) {
        this.username=user;
        setBounds(300, 100, 800, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("DELETE COUSTOMER DETAILS");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        heading.setBounds(110, 10, 300, 30);
        add(heading);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(30, 70, 100, 15);
        add(l1);

        JLabel l11 = new JLabel();
        l11.setBounds(250, 70, 200, 15);
        add(l11);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(30, 110, 100, 15);
        add(l2);

        JLabel l12 = new JLabel();
        l12.setBounds(250, 110, 200, 15);
        add(l12);

        JLabel l3 = new JLabel("ID");
        l3.setBounds(30, 150, 100, 15);
        add(l3);

        JLabel l13 = new JLabel();
        l13.setBounds(250, 150, 200, 15);
        add(l13);

        JLabel l4 = new JLabel("ID Number");
        l4.setBounds(30, 190, 100, 15);
        add(l4);

        JLabel l14 = new JLabel();
        l14.setBounds(250, 190, 200, 15);
        add(l14);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(30, 230, 100, 15);
        add(l5);

        JLabel l15 = new JLabel();
        l15.setBounds(250, 230, 200, 15);
        add(l15);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(30, 270, 100, 15);
        add(l6);

        JLabel l16 = new JLabel();
        l16.setBounds(250, 270, 200, 15);
        add(l16);

        JLabel l7 = new JLabel("Address");
        l7.setBounds(30, 310, 100, 15);
        add(l7);

        JLabel l17 = new JLabel();
        l17.setBounds(250, 310, 200, 15);
        add(l17);

        JLabel l8 = new JLabel("Phone");
        l8.setBounds(30, 350, 100, 15);
        add(l8);

        JLabel l18 = new JLabel();
        l18.setBounds(250, 350, 200, 15);
        add(l18);

        JLabel l9 = new JLabel("Email");
        l9.setBounds(30, 390, 100, 15);
        add(l9);

        JLabel l19 = new JLabel();
        l19.setBounds(250, 390, 200, 15);
        add(l19);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='"+username+"'");
            while (rs.next()) {
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("name"));
                l13.setText(rs.getString("id"));
                l14.setText(rs.getString("number"));
                l15.setText(rs.getString("gender"));
                l16.setText(rs.getString("country"));
                l17.setText(rs.getString("address"));
                l18.setText(rs.getString("phone"));
                l19.setText(rs.getString("email"));
            }
        } catch (Exception e) {
        }
        b1 = new JButton("Delete");
        b1.setBounds(80, 450, 100, 30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(210, 450, 100, 30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(330, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(450, 100, 300, 300);
        add(l10);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
               Conn c= new Conn();
               c.s.executeUpdate("delete from account where username='"+username+"'"); 
               c.s.executeUpdate("delete from bookHotel where username='"+username+"'"); 
               c.s.executeUpdate("delete from bookpackage where username='"+username+"'"); 
               c.s.executeUpdate("delete from customer where username='"+username+"'"); 
               JOptionPane.showMessageDialog(null, "Personal Details Deleted Successfuly");
               System.exit(0);
            } catch (Exception e) {
                
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteCustomer("").setVisible(true);
    }
}
