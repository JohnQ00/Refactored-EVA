package command;

import user.User;

import java.util.ArrayList;

public class Option {
    Command option;
    public void executeOption(ArrayList<User> users, int userId,Command operation){
        Option option = new Option();
        operation.execute(users, userId, option);
    }
}
