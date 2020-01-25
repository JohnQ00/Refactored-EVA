package professor;

import user.User;

import java.util.ArrayList;
import classes.Class;

public class Professor extends User {
    private int classesQuantity;
    private String formation = new String();
    private String specialization = new String();
    private String disciplines[] = new String[500];
    private ArrayList<Class> classes = new ArrayList<>(500);
    private int size = classes.size();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Class getClasses(int classId) {
            return classes.get(classId);
    }

    public void setClasses(Class classIn) {
        this.classes.add(classIn);
    }

    @Override
    public int searchId(ArrayList<User> users, String searchedUsername) {
        for (int i = 0; i < 500; i++){
            if (searchedUsername.equals(users.get(i).getUsername())){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void setAge(int age){
        if(age < 25) {
            System.out.println("Invalid age.");
            return;
        }
        else
            super.setAge(age);
    }

    public String[] getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String[] disciplines) {
        this.disciplines = disciplines;
    }

//    public Classes[][] getClasses() {
//        return classes;
//    }
//
//    public void setClasses(Classes[][] classes) {
//        this.classes = classes;
//    }

    public int getClassesQuantity() {
        return classesQuantity;
    }

    public void setClassesQuantity(int classesQuantity) {
        this.classesQuantity = classesQuantity;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }
}
