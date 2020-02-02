package tests;

import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import texts.TextOptions;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class TestsManagement extends Option implements Command {
    TextOptions text = new TextOptions();
    Scanner entry = new Scanner(System.in);
    ExceptionManagement exception = new ExceptionManagement();
    LessonCreation lesson = new LessonCreation();
    TestCreation test = new TestCreation();
    FactoryOptions options = new FactoryOptions();

    @Override
    public void execute(ArrayList<User> users, int userId, Option optionName) {
        String option;
        text.testOptions();
        int choice = exception.scanInt("Type here: ");

        if (choice == 1){
            option = "Lesson";
            options.getOperation(option).execute(users, userId); //Factory application
        }
        else if (choice == 2){
            option = "Test";
            options.getOperation(option).execute(users, userId); //Factory application
        }
        else return;
    }
}
