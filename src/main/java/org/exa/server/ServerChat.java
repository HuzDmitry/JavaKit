package org.exa.server;

import org.exa.client.ClientChatImpl;
import org.exa.logs.IPAdress;
import org.exa.logs.Loger;
import org.exa.logs.LogerImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServerChat implements ServerChatImpl{
    private ServerGUIImpl serverGUI;
    private Set<ClientChatImpl> clients;
    private boolean work;
    private LogerImpl loger;
    private IPAdress ipAdress;

    public ServerChat(ServerGUIImpl serverGUI, LogerImpl loger) {
        clients = new HashSet<>();
        this.serverGUI = serverGUI;
        serverGUI.setServerChatImpl(this);
        this.loger = loger;
        work = false;
    }
    @Override
    public boolean isWork() {
        return work;
    }

    @Override
    public boolean startServer() {
        ipAdress = new IPAdress(serverGUI.getIP(), serverGUI.getPort());
        work = true;
        serverGUI.printLog("Сервер запущен.");
        return true;
    }

    @Override
    public IPAdress getData() {
        return ipAdress;
    }

    @Override
    public void updateChat(String message) {
        if (isWork() && !clients.isEmpty()){
            for (ClientChatImpl cl : clients){
                cl.printMessage(message);
            }
            serverGUI.printLog(message);
            loger.saveLog(message);
        }
    }

    @Override
    public void deleteClient(ClientChatImpl client) {

    }

    @Override
    public void addClient(ClientChatImpl client) {
        if (work) {
            clients.add(client);
            client.printMessage(loger.loadLog());
        }
    }

    @Override
    public boolean stopServer() {
        work = false;
        clients.clear();
        serverGUI.printLog("Сервер остановлен.");
        return true;
    }
}
