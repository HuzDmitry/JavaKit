package org.exa.client;

import org.exa.logs.IPAdress;
import org.exa.server.ServerChatImpl;

public interface ClientChatImpl {
    void addServer(ServerChatImpl server);
    void addData(IPAdress ipAdress, String name, String password);
    void connectServer();
    void getMessage(String message);
    void printMessage(String message);
}
