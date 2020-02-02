package time;

public class Time {
    private int year = 2020;
    private int[] day = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int counterDate = 2;
    String[] months = {
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
    };
    private int counterMonth = 1;
    private String[] week = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int dayWeek = 0;

    public static Time instance;

    protected Time() {}

    public static Time getInstance(){
        if (instance == null)
            instance = new Time();
        return instance;
    }

    public void getDate() {
        System.out.println("[" + months[counterMonth] + ", " + counterDate + "(" + week[dayWeek] + ")" + " " + year + "]");
    }

    public boolean passDay() {
        counterDate++;
        if (counterDate > day[counterMonth]) {
            counterDate = 1;
            if (counterMonth + 1 > 12) {
                year += 1;
                if(isLeapYear(year)) {day[1] = 29;}
                else {day[1] = 28;}
            }
            counterMonth = (counterMonth + 1) % 12;
            return true;
        }
        dayWeek = (dayWeek + 1) % 7;
        return false;
    }

    private boolean isLeapYear(int year) {
        if(year >= 1 && year <= 5000){
            if(year % 4 == 0){
                if(year % 100 == 0){
                    if(year % 400 == 0){
                        return true;
                    }
                    else return false;
                }
                else return true;
            }
            else return false;
        }
        else
            return false;
    }

    public int getDay(){
        return counterDate;
    }

    public int getMonth(){
        return counterMonth;
    }
}
