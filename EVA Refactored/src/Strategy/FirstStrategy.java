package Strategy;

public class FirstStrategy implements MotherStrategy {

    @Override
    public boolean checkAttendance(Context attendance) {
        if ((1/3) >= 0.25){
            return true;
        }
        else
            return false;
    }
}
