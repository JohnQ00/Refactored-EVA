package tests;

import classes.SearchingInClass;
import exceptions.ExceptionManagement;
import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class TestReceiving {
    public final int a = 0;
    public final int b = 0;
    public final int c = 0;
    public final int d = 0;
    public final int e = 0;

    private int countingCorrect = 0;

    SearchingInClass search = new SearchingInClass();
    Scanner input = new Scanner(System.in);
    ExceptionManagement exception = new ExceptionManagement();

    public void execute(ArrayList<User> users, int userId){
        System.out.println("Listing the classes you are in: ");
        search.listingClasses(users, userId);
        System.out.print("Type here a class: ");
        String selectedClass = input.nextLine();
        int professorId = search.returnProfessorIdthroughClassId(selectedClass, users);
        int classId = search.returnClassId(selectedClass, users, professorId);
        if (professorId == -1 || classId == -1){return;}
        checkingClassTests(users, userId, classId, professorId);
    }

    private void checkingClassTests(ArrayList<User> users, int userId, int classId, int professorId) {
        System.out.println("Checking " + ((Professor) users.get(professorId)).getClasses(classId).getCourse() + " tests.");
        for (int i = 0; i < ((Professor) users.get(professorId)).getClasses(classId).getTestsIndex(); i++){
            System.out.println("Do you wish to answer the test " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(i).getTestNumber() + " now ? [0 to No][1 to Yes]");
            int decision = exception.scanInt("Type here: ");
            if (decision == 1) {
                printingQuestions(userId, users, classId, professorId, i);
            }
        }
    }

    private void printingQuestions(int userId, ArrayList<User> users, int classId, int professorId, int testId) {
        for (int i = 0; i < ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getNumberofQuestions(); i++){
            System.out.println("Lesson's wording: ");
            System.out.println(((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getQuestions()[i]);
            printingAlternatives(userId, users, classId, professorId, testId);
        }
    }

    private void printingAlternatives(int userId, ArrayList<User> users, int classId, int professorId, int testId) {
        System.out.println("a) " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getAlternatives()[a]);
        System.out.println("b) " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getAlternatives()[b]);
        System.out.println("c) " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getAlternatives()[c]);
        System.out.println("d) " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getAlternatives()[d]);
        System.out.println("e) " + ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getAlternatives()[e]);
        System.out.print("Type your answer: ");
        String answer =  input.nextLine();
        if (answer.equalsIgnoreCase(((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getLessonAnswer())) {
            countingCorrect++;
        }
        float grade = ((countingCorrect * 10)/((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getNumberofQuestions());
        ((Student) users.get(userId)).setTestPoints(grade);
        System.out.println("nota em receiving: " + ((Student) users.get(userId)).getTestPoints()[0]);
        ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).setTestPoints(grade, ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).getTestNumber());
        ((Professor) users.get(professorId)).getClasses(classId).getTestsArraylist(testId).setAnswered(true);
    }
}
