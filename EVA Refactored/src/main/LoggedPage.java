package main;

import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import profile.ProfileManagement;
import texts.TextOptions;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class LoggedPage {
    TextOptions text = new TextOptions();
    ExceptionManagement exception = new ExceptionManagement();
    Option option = new Option();

    HashMap<String, Command> studentOptions = new HashMap<>();
    HashMap<String, Command> professorOptions= new HashMap<>();

    public void loginPage(ArrayList<User> users, int userId){
        fillHashMap();
        while(true) {
            text.loggedOptions(users, users.get(userId).getId());
            int choice = exception.scanInt("Type here: ");
            if (choice == 0 || choice > 7) return;
            else {
                if (users.get(userId).getAuthorityLevel() == 1) {
                    option.executeOption(users, userId, studentOptions.get(String.valueOf(choice)));
                } else {
                    option.executeOption(users, userId, professorOptions.get(String.valueOf(choice)));
                }
            }
        }
    }

    public void fillHashMap(){
        studentOptions.put("1", new ProfileManagement());
//        studentOptions.put("2", new ProfileManagement());
//        studentOptions.put("3", new ProfileManagement());
//        studentOptions.put("4", new ProfileManagement());
//        studentOptions.put("5", new ProfileManagement());
//        professorOptions.put("1", new ProfileManagement());
//        professorOptions.put("2", new ProfileManagement());
//        professorOptions.put("3", new ProfileManagement());
//        professorOptions.put("4", new ProfileManagement());
//        professorOptions.put("5", new ProfileManagement());
//        professorOptions.put("6", new ProfileManagement());
    }
}
