package classes;

import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ClassInsertion {
    Scanner input = new Scanner(System.in);
    Student student = new Student();
    SearchingInClass searcher = new SearchingInClass();

    public void classInsertion(ArrayList<User> users, int userId){
        System.out.println("Which course do you want to add students ? ");
        System.out.println("Here's the list of your disciplines: ");
        for (int i = 0; i < ((Professor) users.get(userId)).getClassesQuantity(); i++){
            System.out.println(((Professor) users.get(userId)).getClasses(i).getCourse());
        }

        System.out.print("Type here: ");
        String classSelected = input.nextLine();

        int classIdSelected = searcher.returnClassId(classSelected, users, userId);
        if (classIdSelected == -1){
            System.out.println("Class doesn't exist.");
            return;
        }

        addingStudents(classIdSelected, users, userId);
    }

    private void addingStudents(int classId, ArrayList<User> users, int userId) {

        if (((Professor) users.get(userId)).getClasses(classId).getVacancies() == 0){
            System.out.println("There's no vacancies in this class.");
            return;
        }

        System.out.print("Type here the name of the student you want to add: ");
        String searchingStudent = input.nextLine();

        int studentId = student.searchId(users, searchingStudent);
        if (studentId == -1){
            System.out.println("The student doesn't exist.");
        }
        else{
            if (searchingStudent.equals(((Professor) users.get(userId)).getUsername())){
                System.out.println("You inserted a professor.");
                return;
            }
            if (searcher.checkStudentsInClass(users, classId, userId, searchingStudent)){
                System.out.println("The student is already in this class.");
            }
            else {
                ((Professor) users.get(userId)).getClasses(classId).setClassUsers(searchingStudent);
                ((Professor) users.get(userId)).getClasses(classId).setVacancies(((Professor) users.get(userId)).getClasses(classId).getVacancies() - 1);
                ((Student) users.get(studentId)).setCoursesIn(((Professor) users.get(userId)).getClasses(classId).getCourse());
                System.out.println("\nThe student was sucessfully added.");
            }
        }
    }

}
