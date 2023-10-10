package org.exa;

import org.exa.client.ClientChat;
import org.exa.client.ClientChatImpl;
import org.exa.client.ClientGUI;
import org.exa.client.ClientGUIImpl;
import org.exa.logs.Loger;
import org.exa.server.ServerChat;
import org.exa.server.ServerChatImpl;
import org.exa.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerChatImpl server = new ServerChat(new ServerGUI(), new Loger());
        ClientChatImpl client1 = new ClientChat(new ClientGUI());
        ClientChatImpl client2 = new ClientChat(new ClientGUI());
        client1.addServer(server);
        client2.addServer(server);
    }
}
