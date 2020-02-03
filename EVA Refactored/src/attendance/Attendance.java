package attendance;

public class Attendance {
    private int inIndex = 0;
    private int outIndex = 0;
    private int day;
    private int month;
    private int attendanceNumber;
    private String inStudents[] = new String[500];
    private String outStudents[] = new String[500];

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAttendanceNumber() {
        return attendanceNumber;
    }

    public void setAttendanceNumber(int attendanceNumber) {
        this.attendanceNumber = attendanceNumber;
    }

    public String[] getInStudents() {
        return inStudents;
    }

    public void setInStudents(String inStudents) {
        this.inStudents[inIndex] = inStudents;
        inIndex++;
    }

    public String[] getOutStudents() {
        return outStudents;
    }

    public void setOutStudents(String outStudents) {
        this.outStudents[outIndex] = outStudents;
        outIndex++;
    }
}
