package classes;

import command.Command;
import command.Option;
import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassEntering extends Option implements Command {
    Scanner entry = new Scanner(System.in);
    SearchingInClass searchingInClass = new SearchingInClass();
    Professor professor = new Professor();

    public void execute(ArrayList<User> users, int userId, Option option){
        System.out.print("Type the name of the class you want to enter: ");
        String classChose = entry.next();
        int professorId = searchingInClass.returnProfessorIdthroughClassId(classChose, users);
        if (professorId == -1){
            System.out.println("The class doesn't exist.");
            return;
        }
        System.out.println("Professor: " + (users.get(professorId)).getUsername());
        int classId = searchingInClass.returnClassId2(classChose, users, userId, professorId);
        System.out.println("Class: " + ((Professor) users.get(professorId)).getClasses(classId).getCourse());
        if (classId == -1){
            System.out.println("The class doesn't exist.");
            return;
        }
        testVacancies(users, userId, classId, professorId, classChose);
    }

    private void testVacancies(ArrayList<User> users, int userId, int classId, int professorId, String classChose) {
        if (((Professor) users.get(professorId)).getClasses(classId).getVacancies() == 0){
            System.out.println("The class is full.");
            return;
        }
        if((searchingInClass.checkIfStudentsIsInClass(users, classId, userId, professorId))){
            System.out.println("\nThe student is already in this class.");
            return;
        }
        else{
            ((Student) users.get(userId)).setCoursesIn(classChose);
            ((Professor) users.get(professorId)).getClasses(classId).setClassUsers((users.get(userId)).getUsername());
            ((Professor) users.get(professorId)).getClasses(classId).setVacancies(((Professor) users.get(professorId)).getClasses(classId).getVacancies() - 1);
            System.out.println("\nYou succesfully entered in " + ((Professor) users.get(professorId)).getClasses(classId).getCourse() + " class.\n");
        }
    }
}
