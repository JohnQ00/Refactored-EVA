package messages;

import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import texts.TextOptions;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MessageManagement extends Option implements Command {
    TextOptions text = new TextOptions();
    Scanner entry = new Scanner(System.in);
    ExceptionManagement exception = new ExceptionManagement();
    SendingMessage sender = new SendingMessage();
    CheckingMessageBox receiver = new CheckingMessageBox();

    public void execute(ArrayList<User> users, int userId, Option option){
        text.messageOptions();
        int choice = exception.scanInt("Type here: ");
        if (choice == 1){
            sender.sendingMessage(users, userId);
        }
        else if (choice == 2){
            receiver.receivingMessage(users, userId);
        }
        else{
            return;
        }
    }
}
