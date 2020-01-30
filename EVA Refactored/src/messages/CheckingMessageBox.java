package messages;

import user.User;

import java.util.ArrayList;

public class CheckingMessageBox {
    public void receivingMessage(ArrayList<User> users, int userId){
        System.out.println("\nChecking messages...");
        for (int i = 0; i < users.get(userId).getMessagesQuantity(); i++) {
            for (int j = 0; j < 500; j++) {

                if (users.get(userId).getMessages(i).getSenderUsername()[j] == null)
                    break;
                else
                    System.out.println("Message from " + users.get(userId).getMessages(i).getSenderUsername()[j] + ": \n" + users.get(userId).getMessages(i).getMessageSent()[j]);

            }
        }
    }
}
