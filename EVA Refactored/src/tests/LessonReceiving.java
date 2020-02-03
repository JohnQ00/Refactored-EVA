package tests;

import classes.SearchingInClass;
import exceptions.ExceptionManagement;
import professor.Professor;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LessonReceiving {
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
        checkingClassLessons(users, userId, classId, professorId);
    }

    private void checkingClassLessons(ArrayList<User> users, int userId, int classId, int professorId) {
        System.out.println("Checking " + ((Professor) users.get(professorId)).getClasses(classId).getCourse() + " lessons.");
        for (int i = 0; i < ((Professor) users.get(professorId)).getClasses(classId).getLessonsIndex(); i++){
            System.out.println("Do you wish to answer this lesson now ? [0 to No][1 to Yes]");
            int decision = exception.scanInt("Type here: ");
            if (decision == 1) {
                printingQuestions(userId, users, classId, professorId, i);
            }
        }
    }

    private void printingQuestions(int userId, ArrayList<User> users, int classId, int professorId, int lessonId) {
        for (int i = 0; i < ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getNumberofQuestions(); i++){
            System.out.println("Lesson's wording: ");
            System.out.println(((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getQuestions()[i]);
            printingAlternatives(userId, users, classId, professorId, lessonId);
        }
    }

    private void printingAlternatives(int userId, ArrayList<User> users, int classId, int professorId, int lessonId) {
        System.out.println("a) " + ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getAlternatives()[a]);
        System.out.println("b) " + ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getAlternatives()[b]);
        System.out.println("c) " + ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getAlternatives()[c]);
        System.out.println("d) " + ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getAlternatives()[d]);
        System.out.println("e) " + ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getAlternatives()[e]);
        System.out.println("Type your answer: ");
        String answer =  input.nextLine();
        if (answer.equalsIgnoreCase(((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).getLessonAnswer())) {
            System.out.println("Correct answer.");
            countingCorrect++;
        }
        else {
            System.out.println("Incorrect answer.");
        }
        System.out.println("The number of right answers: " + countingCorrect);
        ((Professor) users.get(professorId)).getClasses(classId).getLessonArraylist(lessonId).setAnswered(true);
    }

}
