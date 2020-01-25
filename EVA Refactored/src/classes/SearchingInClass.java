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

//    protected boolean checkStudentsClass(ArrayList<User> users, int classId, int userId) {
//        if (users.get(userId).getAuthorityLevel() == 2){
//            for (int i = 0; i < 500; i++) {
//                if (((Student) users.get(userId)).getCoursesIn()[i])){
//                    return true;
//                }
//
//            }
//            return false;
//        }
//    }

    protected int returnClassId(String classSelected, ArrayList<User> users, int userId) {
        if (users.get(userId).getAuthorityLevel() == 1){
            for (int i = 0; i < ((Professor) users.get(userId)).getClassesQuantity(); i++) {
                if (classSelected.equalsIgnoreCase(((Professor) users.get(userId)).getClasses(i).getCourse())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
