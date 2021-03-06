package main;

import attendance.AttendanceManagement;
import classes.ClassEntering;
import classes.ClassManagement;
import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import messages.MessageManagement;
import monitor.MonitorManagement;
import profile.ProfileManagement;
import report.ReportManagement;
import tests.TestsManagement;
import tests.TestsOrLessonsReceiving;
import texts.TextOptions;
import time.Time;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class LoggedPage {
    TextOptions text = new TextOptions();
    ExceptionManagement exception = new ExceptionManagement();
    Option option = new Option();
    Time time = Time.getInstance();

    HashMap<String, Command> studentOptions = new HashMap<>();
    HashMap<String, Command> professorOptions= new HashMap<>();

    public void loginPage(ArrayList<User> users, int userId){
        fillHashMap();
        while(true) {
            time.getDate(); // Singleton realizando apenas uma instância para todas as utilizações
            text.loggedOptions(users, users.get(userId).getId());
            int choice = exception.scanInt("Type here: ");
            if (choice == 0 || choice > 7) return;
            else {
                if (users.get(userId).getAuthorityLevel() == 1) {
                    option.executeOption(users, userId, professorOptions.get(String.valueOf(choice)));
                } else {
                    option.executeOption(users, userId, studentOptions.get(String.valueOf(choice)));
                }
            }
        }
    }

    public void fillHashMap(){
        studentOptions.put("1", new ProfileManagement());
        studentOptions.put("2", new ClassEntering());
        studentOptions.put("3", new MessageManagement());
        studentOptions.put("4", new TestsOrLessonsReceiving());
        studentOptions.put("5", new ReportManagement());
        professorOptions.put("1", new ProfileManagement());
        professorOptions.put("2", new ClassManagement());
        professorOptions.put("3", new MessageManagement());
        professorOptions.put("4", new TestsManagement());
        professorOptions.put("5", new AttendanceManagement());
        professorOptions.put("6", new MonitorManagement());
    }
}
