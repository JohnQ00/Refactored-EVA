package classes;

import professor.Professor;
import student.Student;
import user.User;

import java.util.ArrayList;

public class SearchingInClass {
    protected boolean checkStudentsInClass(ArrayList<User> users, int classId, int userId, String searchingStudent) {
        if (users.get(userId).getAuthorityLevel() == 1){
            for (int i = 0; i < 500; i++) {
                if (searchingStudent.equals(((Professor) users.get(userId)).getClasses(classId).getClassUsers()[i]))
                    return true;
            }
        }
        return false;
    }

    protected boolean checkIfStudentsIsInClass(ArrayList<User> users, int classId, int userId, int professorId) {
        if (users.get(userId).getAuthorityLevel() == 2){
            for (int j = 0; j < 500; j++) {
                if ((users.get(userId).getUsername().equals(((Professor) users.get(professorId)).getClasses(classId).getClassUsers()[j]))){
                    return true;
                }
            }
        }
        return false;
    }

    public int returnClassId(String classSelected, ArrayList<User> users, int userId) {
        if (users.get(userId).getAuthorityLevel() == 1){
            for (int i = 0; i < ((Professor) users.get(userId)).getClassesQuantity(); i++) {
                if (classSelected.equalsIgnoreCase(((Professor) users.get(userId)).getClasses(i).getCourse())) {
                    return i;
                }
            }
        }
        return -1;
    }

    protected int returnClassId2(String classSelected, ArrayList<User> users, int userId, int professorId) {
        for (int j = 0; j < 500; j++){
            if (classSelected.equals(((Professor) users.get(professorId)).getClasses(j).getCourse())){
                return j;
            }
        }
        return -1;
    }

    protected int returnProfessorIdthroughClassId(String classChose, ArrayList<User> users){
        for (int i = 0; i < users.size(); i++){
            for (int j = 0; j < 500; j++) {
                if (users.get(i) == null){return -1;}
                else {
                    if (users.get(i).getAuthorityLevel() == 1) {
                        if (((Professor) users.get(i)).getClassesQuantity() == 0) {
                            return -1;
                        }
                        if (classChose.equals(((Professor) users.get(i)).getClasses(j).getCourse())) {
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
