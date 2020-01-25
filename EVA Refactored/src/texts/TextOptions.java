package texts;

import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;

public class TextOptions {
    public void mainOptions(){
        System.out.println();
        System.out.println("    ||| Welcome to EVA |||    ");
        System.out.println("Education in a Virtual Ambient\n");
        System.out.println("Choose an option:");
        System.out.println("0 to Close the system");
        System.out.println("1 to Create an account");
        System.out.println("2 to Login");
    }
    public void creatingOptions(){
        System.out.println("\nTo enter as a administrator just use 'admin' in all credentials.\n");
        System.out.println("Do you want to create a professor or a student account ?\n[1 to Professor]\n[2 to Student]");
    }
    public void loggedOptions(ArrayList<User> users, int userId){
        System.out.println("\nAs a logged user,what you want to do ?");
        System.out.println("0 to Logout");
        System.out.println("1 to Profile");
        if (users.get(userId).getAuthorityLevel() == 1) {
            System.out.println("2 to Class management");
            System.out.println("3 to Message management");
            System.out.println("4 to Test management");
            System.out.println("5 to Turn a student in a monitor");
            System.out.println("6 to Make the attendance");
        }
        if (users.get(userId).getAuthorityLevel() == 2) {
            System.out.println("2 to Enter a class");
            System.out.println("3 to Message management");
            System.out.println("4 to Answer tests");
            System.out.println("5 to See the report card");
        }
    }
    public void profileOptions(){
        System.out.println("\n0 to Return to main screen");
        System.out.println("1 to Create a profile");
        System.out.println("2 to Edit a profile");
        System.out.println("3 to Check a profile");
    }
    public void profileChangeOptions(){
        System.out.println("\nWhat information do you want to change ?");
        System.out.println("0 to None");
        System.out.println("1 to Full name");
        System.out.println("2 to Age");
        System.out.println("3 to E-mail");
        System.out.println("4 to Username");
    }
    public void professorProfileChangeOptions(){
        System.out.println("5 to Number of classes");
        System.out.println("6 to Formation");
        System.out.println("7 to Specialization");
    }
    public void classOptions(){
        System.out.println("\n0 to Return to main screen");
        System.out.println("1 to Create a class");
        System.out.println("2 to Add students");
    }
    public void messageOptions(){
        System.out.println("\n0 to Return to main screen");
        System.out.println("1 to Send a message");
        System.out.println("2 to Check your message box");
    }
}
