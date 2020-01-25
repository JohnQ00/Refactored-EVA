package classes;

public class Class {
    private int index = 0;
    private int aIndex = 0;
    private int lessonsIndex = 0;
    private int testsIndex = 0;
    private int classUsersIndex = 0;
    private String creator = new String();
    public int monitors[] = new int[500];
    private String course = new String();
    private String classUsers[] = new String[500];
    private int vacancies;
    private int classIndex;

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }
//    private Lesson lessons[] = new Lesson[500];
//    private Test tests[] = new Test[4];
//    private Attendance attendances[] = new Attendance[500];

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

//    public int[] getMonitors() {
//        return monitors;
//    }
//
//    public void setMonitors(int monitors) {
//        this.monitors[index] = monitors;
//        index++;
//    }

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

//    public Lesson[] getLessons() {
//        return lessons;
//    }
//
//    public void setLessons(Lesson lessons) {
//        this.lessons[lessonsIndex] = lessons;
//        lessonsIndex++;
//    }
//
//    public Test[] getTests() {
//        return tests;
//    }
//
//    public void setTests(Test tests) {
//        this.tests[testsIndex] = tests;
//        testsIndex++;
//    }
//
//    public Attendance[] getAttendances() {
//        return attendances;
//    }
//
//    public void setAttendances(Attendance attendances) {
//        this.attendances[aIndex] = attendances;
//        aIndex++;
//    }
}
