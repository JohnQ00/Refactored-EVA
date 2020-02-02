package time;

import java.util.Scanner;

public class Administrator {

    Scanner entry = new Scanner(System.in);

    public void managingTime(){
        Time time = Time.getInstance(); //Singleton, apenas uma instância necessária.
        while(true) {
            System.out.println("Exit the time management ?");
            System.out.println("Type: ");
            String exit = entry.next();
            if (exit.equalsIgnoreCase("Yes")){break;}

            System.out.println("Do you want to see the date ?");
            System.out.print("Type: ");
            String decisionTime = entry.next();
            if (decisionTime.equalsIgnoreCase("Yes")) {
                time.getDate();
            }

            System.out.println("Do you want to pass the day ?");
            System.out.print("Type: ");
            String decisionTime0 = entry.next();
            if (decisionTime0.equalsIgnoreCase("Yes")){
                time.passDay();
            }
        }
    }
}
