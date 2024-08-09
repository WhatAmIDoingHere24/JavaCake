import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.crypto.*;
import java.util.random.*;


public class JavaCake {

    public static void main(String[] args) {
        //setup the diffrent windows used
        JFrame frame = new JFrame("JavaCake");
        JFrame server_frame = new JFrame("View Servers");
        JFrame create_frame = new JFrame("Create Server / Node");
        JFrame usr_frame = new JFrame("User Settings");
        JFrame server_settings_frame = new JFrame("Server Settings");
        JFrame node_settings_frame = new JFrame("Node Settings");
        
        // Create a JPanel to hold components
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JPanel server_panel = new JPanel(new GridLayout(3, 3));
        JPanel create_panel = new JPanel(new GridLayout(10, 10));
        JPanel usr_panel = new JPanel(new GridLayout(5, 1));
        JPanel server_settings_panel = new JPanel(new GridLayout(10,10));
        JPanel node_settings_panel = new JPanel(new GridLayout(5,5));
        //JScrollPane scroll_server = new JScrollPane(server_list);
        
        //create UI element objects
        //home page
        JButton view_serv = new JButton("View Servers");
        JButton Create_serv = new JButton("Create Server / Node");
        JButton usr_profile = new JButton("User Settings");
        
        //view servers page !THINK IT OUT!


        //create,manage,settings server/node
        JButton create_server_button = new JButton("Settings/Start Server");
        JButton create_node_button = new JButton("Start Node");
        JLabel server_name_label = new JLabel("SERVER NAME");
        JTextField server_name_text = new JTextField(20);
        JLabel encryption_type_label = new JLabel("Ecryption Type");
        JRadioButton pgp = new JRadioButton("PGP");
        JRadioButton sha256 = new JRadioButton("SHA-256");
        JRadioButton RES = new JRadioButton("RES");
        JRadioButton AES = new JRadioButton("AES");
        JLabel server_Type_label = new JLabel("Public / Private Server");
        JRadioButton Public_server = new JRadioButton("Public");
        JRadioButton Private_server = new JRadioButton("Priavte");
        JLabel private_server_label = new JLabel("Priavte Server Password");
        JTextField private_server_text = new JTextField(20);
        JLabel server_size_label = new JLabel("Max Server Size");
        JSlider server_size_slider = new JSlider(2,20,2);
        server_size_slider.setMajorTickSpacing(2);
        server_size_slider.setSnapToTicks(true);
        int slider_value = server_size_slider.getValue();
        JLabel server_size_counter_label = new JLabel("" + slider_value);
        JLabel min_max_hops_Label = new JLabel("Min / Max Hops through Nodes");
        JSlider min_hops_slider = new JSlider(2,12,2);
        min_hops_slider.setMajorTickSpacing(2);
        min_hops_slider.setSnapToTicks(true);
        JSlider max_hops_slider = new JSlider(1,12,6);
        max_hops_slider.setMajorTickSpacing(2);
        max_hops_slider.setSnapToTicks(true);
        JLabel node_connection_label = new JLabel("Node Connection Security Path");
        JLabel node_warning_label = new JLabel("each successive security is much slower");
        //choose which nodes to use for data transfer,private nodes are only created in node menu
        JRadioButton node_fast = new JRadioButton("Fast");
        JRadioButton node_secure = new JRadioButton("Secure");
        JRadioButton node_very_secure = new JRadioButton("Very Secure");
        JButton save_server_config = new JButton("Save Server Config to File");
        
        //node ID
        String node_security_choice = "A";
        //action listerner sets node_security_choice to a,b,c depending on radiobutton choice
        Random node_id = new Random(); //create random number 
        JLabel node_id_label = new JLabel("Node ID: " + node_id.nextInt(999) + node_security_choice); //create full node id and show user
        ArrayList<String> Node_ID_AL = new ArrayList<>(); //store the ID of all nodes
        String text = node_id_label.getText();
        Node_ID_AL.add(text);
        //node UI
        JRadioButton node_security_type1 = new JRadioButton("open");
        JRadioButton node_security_type2 = new JRadioButton("secure");
        JRadioButton node_security_type3 = new JRadioButton("very secure");
        JRadioButton node_security_type4 = new JRadioButton("Private Node");
        JButton save_node_config = new JButton("Save Node Config to File");
        //depending on the security of the node users will be prompted with diffrent opptions to fill out
        //priavte nodes are nodes with a set path and are the strongest encryption as well as having a bunch fo security features -> 
        // -> that must be filled out to use the node, each node must be a X node to have other X nodes connect to it, this is the ->
        //-> fastes and most secure but it also requires each node to be setup specificly for each client and server



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
        create_server_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server_settings_frame.setVisible(true);
            }
        });
        node_fast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                node_security_choice = "A";
            }
        });
        node_secure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                node_security_choice = "B";
            }
        });
        node_very_secure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                node_security_choice = "C";
            }
        });
        save_node_config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save config file of node as diffrent file types
                String file_type_node = JOptionPane.showInputDialog("Please input a file type ex: .pdf , .xml");
                //write the node id and append file_type_node tot he end of it and save ot to desktop
                //IF SAVED AS .XML ALLOW THE CREATION FO NEW SERVERS AND NODES AS INOUT FROM THE .XML FILE TO FASTEN SETUP 
                File node_config = new File(node_id + file_type_node);
                JOptionPane.showMessageDialog(frame,"file " + node_config + " created", "File Created!" , 1);

            }
        });
        save_server_config.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //save config file of server as diffrent file types
                String file_type_server = JOptionPane.showInputDialog("Please input a file type ex: .pdf , .xml");
                //save name of server and append file type to end and save to desktop
                File server_config = new File(server_name_text + file_type_server);
                JOptionPane.showMessageDialog(frame,"file " + server_config + " created", "File Created!" , 1);
            }
        });

        //home window
        panel.add(view_serv);
        panel.add(Create_serv);
        panel.add(usr_profile);
        
        //view servers window
        //server_panel.add(serverlist);
        //server_panel.add(scroll_server);

        //create,mange,modify servers
        create_panel.add(create_server_button);
        create_panel.add(create_node_button);
        create_panel.add(server_name_label);
        create_panel.add(server_name_text);
        create_panel.add(encryption_type_label);
        create_panel.add(pgp);
        create_panel.add(sha256);
        create_panel.add(AES);
        create_panel.add(RES);
        create_panel.add(server_Type_label);
        create_panel.add(Public_server);
        create_panel.add(Private_server);
        create_panel.add(private_server_label);
        create_panel.add(private_server_text);
        create_panel.add(server_size_label);
        create_panel.add(server_size_slider);
        create_panel.add(server_size_counter_label);
        create_panel.add(min_max_hops_Label);
        create_panel.add(min_hops_slider);
        create_panel.add(max_hops_slider);
        create_panel.add(node_connection_label);
        create_panel.add(node_warning_label);
        create_panel.add(node_fast);
        create_panel.add(node_secure);
        create_panel.add(node_very_secure);
        create_panel.add(save_server_config);
        
        //node window
        node_settings_panel.add(node_id_label);
        node_settings_panel.add(node_security_type1);
        node_settings_panel.add(node_security_type2);
        node_settings_panel.add(node_security_type3);
        node_settings_panel.add(node_security_type4);
        node_settings_panel.add(save_node_config);

        //user settings elemnts
        usr_panel.add(profile_label);
        usr_panel.add(username);
        usr_panel.add(password);
        usr_panel.add(create_profile);
        

        // Add the panel to the frame
        frame.add(panel);
        server_frame.add(server_panel);
        //server_frame.add(scroll_server);
        create_frame.add(create_panel);
        usr_frame.add(usr_panel);
        server_settings_frame.add(server_settings_panel);
        node_settings_frame.add(node_settings_panel);

        // Set the default close operation !FOR ALL!
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the size of the frame
        frame.setSize(300, 300);
        server_frame.setSize(500, 300);
        create_frame.setSize(300,300);
        usr_frame.setSize(300,300);
        server_settings_frame.setSize(300,300);
        node_settings_frame.setSize(300,300);

        // Set the frame to be visible
        //home page frame
        frame.setVisible(true);

        //all other pages must be set false until an action event sets them true
        server_frame.setVisible(false);
        create_frame.setVisible(false);       
        usr_frame.setVisible(false);
        server_settings_frame.setVisible(false);
        node_settings_frame.setVisible(false);

    }
}
