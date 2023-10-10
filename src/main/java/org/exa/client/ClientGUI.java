package org.exa.client;

import org.exa.logs.IPAdress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ClientGUIImpl {
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 300;
    public static int DEFAULT_X = 500;
    public static int DEFAULT_Y = 250;
    public static final String DEFAULT_IP = "127.0.0.1";
    public static final String DEFAULT_PORT = "1234";

    JTextArea log;
    JScrollPane pane;
    JButton login, send;
    JTextField ip, port, password, name, message;
    JPanel north, south;
    ClientChatImpl client;

    public ClientGUI(){
        DEFAULT_X += 50;
        DEFAULT_Y += 50;
        createNorthPanel();
        createSouthPanel();
        createLogPanel();
        createWindow();
    }
    private void createWindow(){
        add(north, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        setTitle("Chat Client");
        setBounds(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //jFrame.setResizable(false);
        setVisible(true);
    }
    private void createNorthPanel(){
        north = new JPanel(new GridLayout(2, 3));
        ip = new JTextField(DEFAULT_IP);
        port = new JTextField(DEFAULT_PORT);
        name = new JTextField("name");
        password = new JPasswordField("1234");
        login = new JButton("login");
        north.add(ip);
        north.add(port);
        north.add(new JLabel());
        north.add(name);
        north.add(password);
        north.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IPAdress ipAdress = new IPAdress(ip.getText(), port.getText());
                client.addData(ipAdress, name.getText(), password.getText());
                client.connectServer();
            }
        });
    }
    private void createSouthPanel(){
        south = new JPanel(new BorderLayout());
        message = new JTextField();
        send = new JButton("send");
        south.add(message);
        south.add(send, BorderLayout.EAST);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.getText().equals("")){
                    client.getMessage(message.getText());
                    message.setText("");
                }
            }
        });
    }
    private void createLogPanel(){
        log = new JTextArea();
        log.setLineWrap(true);
        log.setEditable(false);
        pane = new JScrollPane(log);
    }

    @Override
    public void setClientChatImpl(ClientChatImpl client) {
        this.client = client;
    }

    @Override
    public void printMessage(String message) {
        log.append(message+"\n");
    }
}
