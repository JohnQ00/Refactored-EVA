package strategy;

public class FirstStrategy implements MotherStrategy {

    @Override
    public boolean checkAttendance(Context attendance) {
        if ( (attendance.getAttendanceCounterA()/attendance.getBaseCounter()) >= 0.25){
            return true;
        }
        else
            return false;
    }
}
