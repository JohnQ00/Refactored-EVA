package tests;

import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import texts.TextOptions;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class TestsOrLessonsReceiving extends Option implements Command {
    TextOptions text = new TextOptions();
    Scanner entry = new Scanner(System.in);
    ExceptionManagement exception = new ExceptionManagement();

    @Override
    public void execute(ArrayList<User> users, int userId, Option optionName) {
        text.testReceivingOptions();
        int choice = exception.scanInt("Type here: ");

        if (choice == 1){

        }
        else if (choice == 2){

        }
        else return;
    }
}
