package classes;

import tests.Lessons;
import tests.Tests;

import java.util.ArrayList;
import attendance.Attendance;

public class Class {
    private int index = 0;
    private int aIndex = 0;
    private int classUsersIndex = 0;
    private String creator = new String();
    public int monitors[] = new int[500];
    private String course = new String();
    private String classUsers[] = new String[500];
    private int vacancies;
    private int classIndex;
    private int lessonIndex;
    private int testIndex;
    private int attendanceIndex;

    ArrayList<Lessons> lessonArraylist = new ArrayList<>(500);
    ArrayList<Tests> testsArraylist = new ArrayList<>(4);

    public int getAttendanceIndex() {
        return attendanceIndex;
    }

    public void setAttendanceIndex(int attendanceIndex) {
        this.attendanceIndex = attendanceIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLessonsIndex() {
        return lessonIndex;
    }

    public void setLessonsIndex(int lessonsIndex) {
        this.lessonIndex = lessonsIndex;
    }

    public int getTestsIndex() {
        return testIndex;
    }

    public void setTestsIndex(int testsIndex) {
        this.testIndex = testsIndex;
    }

    public Lessons getLessonArraylist(int lessonId) {
        return lessonArraylist.get(lessonId);
    }

    public void setLessonArraylist(Lessons lessonsIn) {
        this.lessonArraylist.add(lessonsIn);
    }

    public Tests getTestsArraylist(int testId) {
        return testsArraylist.get(testId);
    }

    public void setTestsArraylist(Tests testsIn) {
        this.testsArraylist.add(testsIn);
    }


    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }
    private Attendance attendances[] = new Attendance[500];

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int[] getMonitors() {
        return monitors;
    }

    public void setMonitors(int monitors) {
        this.monitors[index] = monitors;
        index++;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String[] getClassUsers() {
        return classUsers;
    }

    public void setClassUsers(String classUsers) {
        this.classUsers[classUsersIndex] = classUsers;
        classUsersIndex++;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }


    public Attendance[] getAttendances() {
        return attendances;
    }

    public void setAttendances(Attendance attendances) {
        this.attendances[aIndex] = attendances;
        aIndex++;
    }
}
