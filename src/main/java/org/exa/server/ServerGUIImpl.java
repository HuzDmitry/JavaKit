package org.exa.server;

public interface ServerGUIImpl {
    void printLog(String text);
    void setServerChatImpl(ServerChatImpl server);
    String getIP();
    String getPort();
}
