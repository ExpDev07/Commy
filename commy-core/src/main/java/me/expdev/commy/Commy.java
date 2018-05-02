package me.expdev.commy;

import me.expdev.commy.handler.MessageHandler;
import me.expdev.commy.provider.MessagingProvider;
import me.expdev.commy.provider.SenderProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Base commy implementation
 *
 * @param <P> Type of reciever that we will send messages to
 */
public abstract class Commy<P> implements MessagingProvider {

    public static final String CHANNEL_ID = "Commy";

    private MessageHandler defaultHandler = null;
    private Map<String, MessageHandler> handlers = new HashMap<String, MessageHandler>();

    /**
     * Constructs a commy
     */
    public Commy() {

    }

    /**
     * Sets a default handler. Will be used when unknown messages are
     * intercepted through "Commy"
     *
     * @param handler Handler
     */
    public void setDefaultHandler(MessageHandler handler) {
        this.defaultHandler = handler;
    }

    /**
     * Adds a handler for handling of incoming messages
     *
     * @param tag Tag
     * @param handler Handler
     */
    public void addHandler(String tag, MessageHandler handler) {
        handlers.put(tag, handler);
    }

    /**
     * Handles a message
     *
     * @param tag Routing tag/id of message
     * @param message Message to handle
     */
    protected void handleMessage(Connection sender, String tag, String message) {
        // Attempt to route to appropriate handler
        MessageHandler handler = handlers.get(tag);
        if (handler == null) {
            // Have message handled by default handler if set
            if (defaultHandler != null) defaultHandler.handle(sender, tag, message);
            return;
        }
        // Handle message appropriately
        handler.handle(sender, tag, message);
    }

    /**
     * Setup appropriate stuff
     *
     * @return Self
     */
    public abstract Commy setup();

}
