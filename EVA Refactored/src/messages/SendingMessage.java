package messages;

import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class SendingMessage {
    int id = 0;
    Scanner entry = new Scanner(System.in);
    private MessageBox message = new MessageBox();

    public void sendingMessage(ArrayList<User> users, int userId){
        System.out.println("Insert the name of the user you want to send a message: ");
        String userName = entry.nextLine();
        int receiverId = checkUserExistence(users, userName);
        if (receiverId == -1){
            System.out.println("The user doesn't exist.");
            return;
        }

        id++;
        System.out.println("Receiver Id: " + receiverId);
        storingMessage(users, receiverId, userId);
        System.out.println("Message successfully sent.");
    }

    private void storingMessage(ArrayList<User> users, int receiverId, int userId) {
        message = new MessageBox();
        System.out.println("Write down your message: ");
        message.setMessageSent(entry.nextLine());
        message.setSenderUsername(users.get(userId).getUsername());
        message.setMessageId(id);
        users.get(receiverId).setMessages(message);
        //System.out.println("Message from" + users.get(userId).getMessages(0).getSenderUsername() + ": \n" + users.get(userId).getMessages(0).getMessageSent());
        //printClass(users, receiverId);
        users.get(receiverId).setMessagesQuantity(id);

    }

    private int checkUserExistence(ArrayList<User> users, String userName) {
        for (User c: users) {
            if (c != null){
                if (userName.equals(c.getUsername())){
                    System.out.println("The user exists.\n");
                    return c.getId();
                }
            }
        }
        return -1;
    }

    private void printClass(ArrayList<User> users, int receiverId){
        System.out.println("ID: " + id);
        System.out.println("SIZE: " + users.get(receiverId).getSize2());
        System.out.println("SENDER: " + (users.get(receiverId)).getMessages(id - 1).getSenderUsername()[0]);
        System.out.println("MESSAGE: " + (users.get(receiverId)).getMessages(id - 1).getMessageSent()[0]);
    }
}
