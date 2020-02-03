package time;

import exceptions.ExceptionManagement;
import texts.TextOptions;

import java.util.Scanner;

public class Administrator {

    Scanner entry = new Scanner(System.in);
    ExceptionManagement exception = new ExceptionManagement();
    TextOptions text = new TextOptions();

    public void managingTime(){
        Time time = Time.getInstance(); //Singleton, apenas uma instância necessária.
        while(true) {
            text.timeOptions();
            int choice = exception.scanInt("Type: ");
            if (choice == 1){
                time.getDate();
            }
            else if(choice == 2){
                time.passDay();
            }
            else{
                return;
            }
        }
    }
}
