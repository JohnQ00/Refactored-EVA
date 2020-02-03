package monitor;

import classes.SearchingInClass;
import command.Command;
import command.Option;
import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MonitorManagement extends Option implements Command {

    Scanner entry = new Scanner(System.in);
    Student student = new Student();
    SearchingInClass search = new SearchingInClass();

    @Override
    public void execute(ArrayList<User> users, int userId, Option optionName) {
        turnIntoMonitor(userId, users);
    }

    public void turnIntoMonitor(int userId, ArrayList<User> users){
        System.out.println("Showing all of your classes: ");
        search.listingProfessorClasses(users, userId);
        System.out.println("Choose a class:");
        String classC = entry.nextLine();
        System.out.print("Choose a student: ");
        int classNumber = search.returnClassId(classC, users, userId);
        if(classNumber < 0 || classNumber >= 500){
            return;
        }
        search.listingProfessorStudents(users, userId, classNumber);
        System.out.print("Choose a student to become a monitor: ");
        String studentToMonitor = entry.next();
        int studentIndex = student.searchId(users, studentToMonitor);
        ((Student) users.get(studentIndex)).monitor = true;
        ((Professor) users.get(userId)).getClasses(classNumber).setMonitors(studentIndex);
        System.out.println("Now "+ (users.get(studentIndex)).getUsername() + " is a monitor.\n");
    }
}
