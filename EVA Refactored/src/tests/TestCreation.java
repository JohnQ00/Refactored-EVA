package tests;

import classes.SearchingInClass;
import exceptions.ExceptionManagement;
import professor.Professor;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCreation implements Factory {
    Scanner input = new Scanner(System.in);
    SearchingInClass search = new SearchingInClass();
    ExceptionManagement exception = new ExceptionManagement();
    Tests test;
    int id = 0;

    @Override
    public void execute(ArrayList<User> users, int userId) {
        testCreation(users, userId);
    }

    private void testCreation(ArrayList<User> users, int userId) {
        System.out.println("Here's a list of your classes: ");
        unrollingClasses(users, userId);
        System.out.print("Choose a class to send a test: ");
        String selectedClass = input.nextLine();
        int classId = search.returnClassId(selectedClass, users, userId);
        if (classId == -1){
            System.out.println("The class doesn't exist.");
            return;
        }
        settingInfo(users, userId, classId);
    }

    private void settingInfo(ArrayList<User> users, int userId, int classId) {
        test = new Tests();
        id++;
        int testNumber = exception.scanInt("Choose the test number: ");
        test.setTestNumber(testNumber);
        ((Professor) users.get(userId)).getClasses(classId).setTestsIndex(id);
        test.setLeadingCourse(((Professor) users.get(userId)).getClasses(classId).getCourse());
        int questionQuantity = exception.scanInt("Choose the number of questions: ");
        test.setNumberofQuestions(questionQuantity);

        ((Professor) users.get(userId)).getClasses(classId).setLessonArraylist(creatingQuestions(users, userId, classId, questionQuantity));
        System.out.println("You successfully sent a test to " + ((Professor) users.get(userId)).getClasses(classId).getCourse() + " class.");

    }

    private Tests creatingQuestions(ArrayList<User> users, int userId, int classId, int questionNumber) {
        for (int i = 0; i < questionNumber; i++){
            System.out.print("Write the wording of the question: ");
            String wording = input.nextLine();

            test.setQuestions(wording);
            creatingAlternatives(users, userId, classId);

            while (true) {
                System.out.print("Insert the right alternative: ");
                String rightAnswer = input.next();
                if (rightAnswer.equalsIgnoreCase("a")
                        || rightAnswer.equalsIgnoreCase("b")
                        || rightAnswer.equalsIgnoreCase("c")
                        || rightAnswer.equalsIgnoreCase("d")
                        || rightAnswer.equalsIgnoreCase("e")) {
                    test.setLessonAnswer(rightAnswer);
                    break;
                } else {
                    System.out.println("Enter a valid alternative.");
                }
            }
            return test;
        }
        return null;
    }

    private void creatingAlternatives(ArrayList<User> users, int userId, int classId) {
        for (int i = 0; i < 5; i++){
            System.out.println("Insert the alternative text: ");
            String alternatives = input.nextLine();
            test.setAlternatives(alternatives);
        }
    }

    private void unrollingClasses(ArrayList<User> users, int userId) {
        for (int i = 0; i < ((Professor) users.get(userId)).getClassesQuantity(); i++){
            System.out.println(((Professor) users.get(userId)).getClasses(i).getCourse());
        }
    }
}
