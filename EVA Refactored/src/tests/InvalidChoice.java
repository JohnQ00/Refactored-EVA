package tests;

import user.User;

import java.util.ArrayList;

public class InvalidChoice implements Factory{
    @Override
    public void execute(ArrayList<User> users, int userId) {
        System.out.println("Invalid Choice! Insert a valid choice!");
    }
}
