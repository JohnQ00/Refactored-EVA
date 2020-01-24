package student;

import user.User;

public class Student extends User {
    private int index = 0;
    private int registrationNumber;
    private String universityDiscipline = new String();
    private int universityPeriod;
    private int ingressionYear;
    private String coursesIn[] = new String[500];
    public boolean monitor;

    public String[] getCoursesIn() {
        return coursesIn;
    }

    public void setCoursesIn(String coursesIn) {
        this.coursesIn[index] = coursesIn; index++;
    }

//    public boolean isMonitor() {
//        return monitor;
//    }
//
//    public void setMonitor(boolean monitor) {
//        this.monitor = monitor;
//    }

    @Override
    public void setAge(int age){
        if(age < 18) {
            System.out.println("Invalid age.");
            return;
        }
        else
            super.setAge(age);
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getUniversityDiscipline() { return universityDiscipline; }

    public void setUniversityDiscipline(String universityDiscipline) { this.universityDiscipline = universityDiscipline; }

    public int getUniversityPeriod() { return universityPeriod; }

    public void setUniversityPeriod(int universityPeriod) { this.universityPeriod = universityPeriod; }

    public int getIngressionYear() { return ingressionYear; }

    public void setIngressionYear(int ingressionYear) { this.ingressionYear = ingressionYear; }
}
