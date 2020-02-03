package report;

import Strategy.Context;
import classes.SearchingInClass;
import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import professor.Professor;
import texts.TextOptions;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportManagement extends Option implements Command {
    ExceptionManagement exception = new ExceptionManagement();
    TextOptions text =  new TextOptions();
    Scanner input = new Scanner(System.in);
    SearchingInClass search = new SearchingInClass();
    Context strategy;

    @Override
    public void execute(ArrayList<User> users, int userId, Option optionName) {
        generateReportCard(users, userId);
    }

    private void generateReportCard(ArrayList<User> users, int userId) {
        System.out.println("\nListing the classes you are in: ");
        search.listingClasses(users, userId);
        System.out.print("Type here a class: ");
        String selectedClass = input.nextLine();
        int professorId = search.returnProfessorIdthroughClassId(selectedClass, users);
        int classId = search.returnClassId(selectedClass, users, professorId);
        if (professorId == -1 || classId == -1){return;}
        makingTheReportCard(users, userId, professorId, classId);
    }

    private void makingTheReportCard(ArrayList<User> users, int userId, int professorId, int classId) {
        strategy  = new Context(users, userId, professorId, classId);
        boolean isIn = search.checkIfStudentsIsInClass(users, classId, userId, professorId);
        if (!isIn){return;}
        else {
            float meanCalculus = printingGrades(users, userId, professorId, classId);

            if (strategy.checkAttendance()){
                if (meanCalculus >= 7.0){
                    System.out.println("\nYour final grade is: " + meanCalculus);
                    System.out.println(users.get(userId).getUsername() + " was approved.\n");
                }
                else{
                    System.out.println("\nYour final grade is: " + meanCalculus);
                    System.out.println(users.get(userId).getUsername() + " was not approved.\n");
                }
            }
            else{
                if (meanCalculus >= 7.0){
                    System.out.println("\nYour final grade is: " + meanCalculus);
                    System.out.println(users.get(userId).getUsername() + " was not approved.\n");
                }
            }
        }
    }

    private float printingGrades(ArrayList<User> users, int userId, int professorId, int classId) {
        float mean = 0;
        for (int i = 1; i < ((Professor) users.get(professorId)).getClasses(classId).getTestsIndex(); i++){
            System.out.println("Points: " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(i).getTestPoints()[i]);
            if (((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(i).getTestPoints()[i] >= 0){
                System.out.println("AV" + i);
                System.out.println("Grade: " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(i).getTestPoints()[i]);
                mean += ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(i).getTestPoints()[i];
            }
        }
        return mean/ ((Professor) users.get(professorId)).getClasses(classId).getTestsIndex();
    }
}
