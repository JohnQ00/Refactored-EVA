package classes;

import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import texts.TextOptions;
import user.User;

import java.util.ArrayList;

public class ClassManagement extends Option implements Command {

    TextOptions text = new TextOptions();
    ExceptionManagement exception = new ExceptionManagement();
    ClassCreation creation = new ClassCreation();
    ClassInsertion adding = new ClassInsertion();

    public void execute(ArrayList<User> users, int userId, Option option){
        text.classOptions();
        int choice = exception.scanInt("Type here: ");
        if (choice == 1){
            creation.classCreation(users, userId);
        }
        else if (choice == 2){
            adding.classInsertion(users, userId);
        }
        else return;
    }
}
