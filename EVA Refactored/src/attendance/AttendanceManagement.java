package attendance;

import classes.SearchingInClass;
import command.Command;
import command.Option;
import professor.Professor;
import time.Time;
import user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class AttendanceManagement extends Option implements Command {

    Attendance attendance;
    SearchingInClass search = new SearchingInClass();
    Scanner input = new Scanner(System.in);
    Time time = Time.getInstance();
    int id = 0;

    public void execute(ArrayList<User> users, int userId, Option optionName) {
        resolvingAttendance(users, userId);
    }

    private void resolvingAttendance(ArrayList<User> users, int userId) {
        attendance = new Attendance();
        System.out.println("Here's the list of your classes: ");
        search.listingProfessorClasses(users, userId);
        System.out.print("Choose a class: ");
        String selectedClass = input.nextLine();
        int classId = search.returnClassId(selectedClass, users, userId);
        if (classId == -1){
            System.out.println("The class doesn't exist.");
            return;
        }
        id++;
        attendance.setDay(time.getDay());
        attendance.setMonth(time.getMonth());
        ((Professor) users.get(userId)).getClasses(classId).setAttendanceIndex(id);
        ((Professor) users.get(userId)).getClasses(classId).setAttendances(attendance);
        selectingStudents(users, userId, classId);
    }

    private void selectingStudents(ArrayList<User> users, int userId, int classId) {
        System.out.println("The students of " + ((Professor) users.get(userId)).getClasses(classId).getCourse() + " class: ");
        for (int i = 0; i < ((Professor) users.get(userId)).getClasses(classId).getVacancies(); i++){
            if (((Professor) users.get(userId)).getClasses(classId).getClassUsers()[i] != null){
                System.out.println("Student [" + ((Professor) users.get(userId)).getClasses(classId).getClassUsers()[i]+"]");
                attendanceFinish(userId, users, classId, i);
            }
        }
    }

    private void attendanceFinish(int userId, ArrayList<User> users, int classId, int studentId) {
        System.out.println("Mark if the student is on the class: ");
        String inOrOut = input.next();
        ((Professor) users.get(userId)).getClasses(classId).getAttendances()[studentId].setAttendanceNumber(+1);
        if (inOrOut.equalsIgnoreCase("Yes")){
            ((Professor) users.get(userId)).getClasses(classId).getAttendances()[studentId].setInStudents(users.get(studentId).getUsername());
            ((Professor) users.get(userId)).getClasses(classId).getAttendances()[studentId].setOutStudents("null");
        }
        else{
            ((Professor) users.get(userId)).getClasses(classId).getAttendances()[studentId].setInStudents("null");
            ((Professor) users.get(userId)).getClasses(classId).getAttendances()[studentId].setOutStudents(users.get(studentId).getUsername());
        }
    }
}
