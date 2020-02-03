package Strategy;

import professor.Professor;
import user.User;

import java.util.ArrayList;

public class Context {
    MotherStrategy strategy;
    int attendanceCounterA = 0;
    int attendanceCounterB = 0;
    int baseCounter = 1;

    public Context(ArrayList<User> users, int userId, int professorId, int classId){
        strategy = new FirstStrategy();
        int i;
        baseCounter = ((Professor) users.get(professorId)).getClasses(classId).getAttendanceIndex() + 1;
        for (i = 0; i < ((Professor) users.get(professorId)).getClasses(classId).getAttendanceIndex(); i++){
            if (((Professor) users.get(professorId)).getClasses(classId).getAttendances()[i] != null) {
                if (users.get(userId).getUsername().equals(((Professor) users.get(professorId)).getClasses(classId).getAttendances()[i].getInStudents()[i])) {
                    attendanceCounterA++;
                }
                if (users.get(userId).getUsername().equals(((Professor) users.get(professorId)).getClasses(classId).getAttendances()[i].getOutStudents()[i])) {
                    attendanceCounterB++;
                }
            }
            else
                break;
        }
    }

    public int getBaseCounter() {
        return baseCounter;
    }

    public boolean checkAttendance(){
        return strategy.checkAttendance(this);
    }

    public int getAttendanceCounterA() {
        return attendanceCounterA;
    }
}
