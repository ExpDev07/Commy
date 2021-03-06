package com.github.expdev07.commy.bungee;

import com.github.expdev07.commy.core.BytesOutput;
import com.github.expdev07.commy.core.Connection;
import com.google.gson.Gson;
import net.md_5.bungee.api.config.ServerInfo;

/**
 * A bungee plugin implementation of commy's connection
 */
public class BungeeConnection implements Connection<ServerInfo> {

    private String channel;
    private ServerInfo server;

    public BungeeConnection(String channel, ServerInfo server) {
        this.channel = channel;
        this.server = server;
    }

    @Override
    public void sendMessage(String proxy, byte[] message) {
        byte[] out = new BytesOutput().write(proxy, new String(message)).getBytes();
        server.sendData(channel, out);
    }

    @Override
    public void sendMessage(String proxy, String message) {
        this.sendMessage(proxy, message.getBytes());
    }

    @Override
    public void sendMessage(String proxy, Object message) {
        this.sendMessage(proxy, new Gson().toJson(message));
    }

    @Override
    public ServerInfo getSender() {
        return server;
    }


}
