package org.exa.server;

import org.exa.client.ClientChatImpl;
import org.exa.logs.IPAdress;

public interface ServerChatImpl {
    boolean startServer();
    boolean stopServer();
    void addClient(ClientChatImpl client);
    void updateChat(String message);
    void deleteClient(ClientChatImpl client);
    IPAdress getData();
    boolean isWork();
}
