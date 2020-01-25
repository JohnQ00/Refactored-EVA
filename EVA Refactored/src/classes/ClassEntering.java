package classes;

import command.Command;
import command.Option;
import professor.Professor;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassEntering extends Option implements Command {
    Scanner entry = new Scanner(System.in);
    SearchingInClass searchingInClass = new SearchingInClass();

    public void execute(ArrayList<User> users, int userId, Option option){
        System.out.print("Type the name of the class you want to enter: ");
        String classChose = entry.next();
        int classId = searchingInClass.returnClassId(classChose, users, userId);
        if (classId == -1){
            System.out.println("The class doesn't exist.");
            return;
        }
        testVacancies(users, userId, classId);
    }

    private void testVacancies(ArrayList<User> users, int userId, int classId) {
        if (((Professor) users.get(userId)).getClasses(classId).getVacancies() == 0){
            System.out.println("The class is full.");
            return;
        }
        //searchingInClass.checkStudentsClass(users, classId, userId, ((Professor) users.get()))
    }
}
