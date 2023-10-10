package org.exa.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ServerGUIImpl {
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 300;
    public static final int DEFAULT_X = 100;
    public static final int DEFAULT_Y = 250;
    public static final String DEFAULT_IP = "127.0.0.1";
    public static final String DEFAULT_PORT = "1234";

    JButton start, stop;
    JPanel nordPanel, southPanel;
    JTextArea log;
    JTextField ip, port;
    JScrollPane pane;
    ServerChatImpl server;

    public ServerGUI() {
        createNorthPane();
        createSouthPane();
        createLogPane();
        createWindow();
    }
    private void createWindow(){
        add(nordPanel, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        setTitle("Chat Server");
        setBounds(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jFrame.setResizable(false);
        setVisible(true);
    }
    private void createNorthPane(){
        nordPanel = new JPanel(new GridLayout(2, 2));
        ip = new JTextField(DEFAULT_IP);
        port = new JTextField(DEFAULT_PORT);
        nordPanel.add(new JLabel(" IP: "));
        nordPanel.add(ip);
        nordPanel.add(new Label(" PORT: "));
        nordPanel.add(port);
    }
    private void createSouthPane(){
        southPanel = new JPanel(new GridLayout(1, 2));
        start = new JButton("Start server");
        stop = new JButton("Stop server");
        stop.setEnabled(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.startServer()){
                    start.setEnabled(false);
                    stop.setEnabled(true);
                }
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.stopServer()){
                    start.setEnabled(true);
                    stop.setEnabled(false);
                }
            }
        });
        southPanel.add(start);
        southPanel.add(stop);
    }
    private void createLogPane(){
        log = new JTextArea();
        log.setLineWrap(true);
        log.setEditable(false);
        pane = new JScrollPane(log);
    }

    @Override
    public String getIP() {
        return ip.getText();
    }

    @Override
    public String getPort() {
        return port.getText();
    }

    @Override
    public void setServerChatImpl(ServerChatImpl server) {
        this.server = server;
    }

    @Override
    public void printLog(String text) {
        log.append(text + "\n");
    }
}
