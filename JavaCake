import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
//import javax.crypto.*;
//import javax.security.*;


public class JavaCake {

    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("JavaCake");
        JFrame server_frame = new JFrame("server frame");
        JFrame create_frame = new JFrame("Create frame");
        JFrame usr_frame = new JFrame("Create frame");
        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        JPanel server_panel = new JPanel();
        JPanel create_panel = new JPanel();
        JPanel usr_panel = new JPanel();
        //create UI element objects
        JButton view_serv = new JButton("view servers");
        JButton Create_serv = new JButton("create server");
        JButton usr_profile = new JButton("user profile");
        
        JButton server_test = new JButton("it worked!");

        JButton create_test = new JButton("it worked!");

        JButton usr_test = new JButton("it worked!");

        // Add an ActionListener
        view_serv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server_frame.setVisible(true);
            }
        });
        Create_serv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create_frame.setVisible(true);
            }
        });
        usr_profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usr_frame.setVisible(true);
            }
        });

        // Add the button to the panel
        panel.add(view_serv);
        panel.add(Create_serv);
        panel.add(usr_profile);
        
        server_panel.add(server_test);

        create_panel.add(create_test);


        // Add the panel to the frame
        frame.add(panel);
        server_frame.add(server_panel);
        create_frame.add(create_panel);
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the frame
        frame.setSize(300, 300);
        server_frame.setSize(500, 300);
        create_frame.setSize(300,300);
        // Set the frame to be visible
        frame.setVisible(true);
        server_frame.setVisible(false);
        create_frame.setVisible(false);       
    }
}
