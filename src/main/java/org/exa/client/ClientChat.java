package org.exa.client;

import org.exa.logs.IPAdress;
import org.exa.server.ServerChatImpl;

public class ClientChat implements ClientChatImpl{
    private String name;
    private String password;
    private IPAdress ipAdres;
    private ClientGUIImpl clientGUI;
    private ServerChatImpl server;

    public ClientChat(ClientGUIImpl clientGUI){
        this.clientGUI = clientGUI;
        clientGUI.setClientChatImpl(this);
    }
    @Override
    public void addServer(ServerChatImpl server){
        this.server = server;
    }

    @Override
    public void connectServer() {
        if (server.isWork()){
            if (server.getData().equals(ipAdres)){
                server.addClient(this);
                clientGUI.printMessage("Подключен к серверу.");
            }else
                clientGUI.printMessage("неправильный ip или port");
        }else
            clientGUI.printMessage("сервер не недоступен.");
    }

    @Override
    public void addData(IPAdress ipAdress, String name, String password) {
        this.ipAdres = ipAdress;
        this.name = name;
        this.password = password;
    }

    /**
     * Передача сообщения на сервер
     * @param message
     */
    @Override
    public void getMessage(String message) {
       String nameMessage = name +": "+ message;
       server.updateChat(nameMessage);
    }

    /**
     * Вывести сообщение на экран клиента
     * @param message
     */
    @Override
    public void printMessage(String message) {
        clientGUI.printMessage(message);
    }

    @Override
    public String toString() {
        return name;
    }
}
