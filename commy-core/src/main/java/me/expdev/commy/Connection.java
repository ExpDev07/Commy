package me.expdev.commy;

/**
 * Project created by ExpDev
 */
public interface Connection<T> {

   /**
    * Sends a message to the connection
    *
    * @param tag     Tag of message
    * @param message Message (string) to send
    */
   void sendMessage(String tag, String message);

   /**
    * Sends a message to the connection
    *
    * @param message Message to send
    */
   void sendMessage(Message message);

   /**
    * Gets the "sender" for the connection
    *
    * @return Sender o
    */
   T getSender();

}
