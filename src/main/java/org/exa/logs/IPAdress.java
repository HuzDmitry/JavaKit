package org.exa.logs;

import java.util.Objects;

public class IPAdress {
    private final String ip;
    private final String port;

    public IPAdress(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return ip +":"+ port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPAdress ipAdress = (IPAdress) o;
        return Objects.equals(ip, ipAdress.ip) && Objects.equals(port, ipAdress.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }
}
