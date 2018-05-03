package com.github.expdev07.commy.core.handler;

import com.github.expdev07.commy.core.Connection;

/**
 * A simple handler interface for handling messages
 *
 * @param <T> Type of source we will communicate with
 */
public interface MessageHandler<T> {

    /**
     * Handles a incoming message
     *
     * @param conn    Connection for message
     * @param tag     Tag of message
     * @param message Message recieved
     */
    void handle(Connection<T> conn, String tag, String message);

}