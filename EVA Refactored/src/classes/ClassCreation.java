package classes;

import exceptions.ExceptionManagement;
import professor.Professor;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassCreation {

    private Class classes = new Class();
    Scanner entry = new Scanner(System.in);
    ExceptionManagement exception = new ExceptionManagement();
    int id = 0;

    public void classCreation(ArrayList<User> users, int userId){
        setClassInfo(users, userId);
    }

    private void setClassInfo(ArrayList<User> users, int userId) {
        classes = new Class();
        classes.setClassIndex(id);
        id++;
        System.out.print("Insert the name of discipline you teach: ");
        classes.setCourse(entry.nextLine());
        classes.setVacancies(exception.scanInt("Insert the number of vacancies you want to dispose: "));
        classes.setCreator(users.get(userId).getUsername());
        ((Professor) users.get(userId)).setClasses(classes);
        System.out.println("\nYour class was successfully created.\n");
        ((Professor) users.get(userId)).setClassesQuantity(id);
        //printClass(users,userId);
    }

    private void printClass(ArrayList<User> users, int userId){
        System.out.println("ID: " + id);
        System.out.println("class name: " + ((Professor) users.get(userId)).getClasses(id).getCourse());
    }
}
