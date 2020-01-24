package professor;

import user.User;

public class Professor extends User {
    private int classesQuantity;
    private String formation = new String();
    private String specialization = new String();
    private String disciplines[][] = new String[500][500];
    //private Classes classes[][] = new Classes[500][500];

    @Override
    public void setAge(int age){
        if(age < 25) {
            System.out.println("Invalid age.");
            return;
        }
        else
            super.setAge(age);
    }

    public String[][] getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String[][] disciplines) {
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
