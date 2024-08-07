import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.crypto.*;


public class JavaCake {

    public static void main(String[] args) {
        //setup the diffrent windows used
        JFrame frame = new JFrame("JavaCake");
        JFrame server_frame = new JFrame("View Servers");
        JFrame create_frame = new JFrame("Create Server / Node");
        JFrame usr_frame = new JFrame("User Settings");
        
        // Create a JPanel to hold components
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JPanel server_panel = new JPanel(new GridLayout(3, 3));
        JPanel create_panel = new JPanel(new GridLayout(3, 3));
        JPanel usr_panel = new JPanel(new GridLayout(5, 1));
        JScrollPane scroll_server = new JScrollPane(server_list);
        
        //create UI element objects
        //home page
        JButton view_serv = new JButton("View Servers");
        JButton Create_serv = new JButton("Create Server / Node");
        JButton usr_profile = new JButton("User Settings");
        
        //view servers page
        //add a scrollable list of all servers
        String[] server_array = {"one", "two", "three", "four"};
        DefaultListModel<String> server_list = new DefaultListModel<>();
        JList<String> serverlist = new JList<>(server_list);
        serverlist.setBounds(100,100,200,100);

        //create,manage,settings server/node
        JButton create_server_button = new JButton("Create Server");
        JButton create_node_button = new JButton("Establish Node");

        //user settings page
        //page for setting(s) and creating user accounts
        //label
        JLabel profile_label = new JLabel("Text input cannot contain spaces",JLabel.CENTER);
        //username set
        JTextField username = new JTextField("username",20);
        //password set
        JTextField password = new JTextField("password",20);
        //create another account(s)
        JButton create_profile = new JButton("Create Profile(s)");
        //personal usr profiles array
        ArrayList<String> USR_profiles = new ArrayList<String>();
        //personal password profiles array
        ArrayList<String> Pass_profiles = new ArrayList<String>();


        //create user interaction events that trigger things to happen
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
        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usrnme = username.getText();
                if(username.getText() == " " || username.getText() == ""){
                    JOptionPane.showMessageDialog(frame, "SYNTAX ERROR", "pls refrain from adding weird or undisclosed charecters to the username field", JOptionPane.INFORMATION_MESSAGE);
                    username.selectAll();
                }else{
                    username.selectAll();
                    USR_profiles.add(usrnme);
                    System.out.println(USR_profiles);
                        
                }
            }
        });
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pas = password.getText();
                if(password.getText() == " " || password.getText() == ""){
                    JOptionPane.showMessageDialog(frame, "SYNTAX ERROR", "pls refrain from adding weird or undisclosed charecters to the username field", JOptionPane.INFORMATION_MESSAGE);
                    password.selectAll();
                }else{
                    password.selectAll();
                    Pass_profiles.add(pas);
                    System.out.println(Pass_profiles);
                        
                }
            }
        });
        // Add a selection listener to handle clicks
        server_list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // To avoid multiple events for single click
                String selectedItem = server_list.getSelectedValue();
                if (selectedItem != null) {
                    JOptionPane.showMessageDialog(frame, "Selected: " + selectedItem);
                }
            }
        });

        // pack elemnts to panel
        panel.add(view_serv);
        panel.add(Create_serv);
        panel.add(usr_profile);
        
        //view servers
        server_panel.add(serverlist);
        server_panel.add(scroll_server);

        //create,mange,modify servers and nodes
        create_panel.add(create_server_button);
        create_panel.add(create_node_button);

        //user settings elemnts
        usr_panel.add(profile_label);
        usr_panel.add(username);
        usr_panel.add(password);
        usr_panel.add(create_profile);
        

        // Add the panel to the frame
        frame.add(panel);
        server_frame.add(server_panel);
        server_frame.add(scroll_server);
        create_frame.add(create_panel);
        usr_frame.add(usr_panel);

        // Set the default close operation !FOR ALL!
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the size of the frame
        frame.setSize(300, 300);
        server_frame.setSize(500, 300);
        create_frame.setSize(300,300);
        usr_frame.setSize(300,300);

        // Set the frame to be visible
        //home page frame
        frame.setVisible(true);

        //all other pages must be set false until an action event sets them true
        server_frame.setVisible(false);
        create_frame.setVisible(false);       
        usr_frame.setVisible(false);

    }
}
