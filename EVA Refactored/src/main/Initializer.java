package main;

import java.util.ArrayList;
import java.util.Scanner;

import professor.Professor;
import student.Student;
import user.User;
import texts.TextOptions;

public class Initializer {

    final int max = 500;
    ArrayList<User> users = new ArrayList<User>(max);
    public Scanner input = new Scanner(System.in);
    public User user;

    TextOptions text = new TextOptions();

    public void Init(){
        while(true){
            text.MainOptions();
            int choice = input.nextInt();

            if(choice == 0){
                System.out.println("\nClosing the system.");
                break;
            }

            else if(choice == 1){
                text.CreatingOptions();
                choice = input.nextInt();
                user = setAuthority(choice, user);
                System.out.println("user authority: " + user.getAuthorityLevel());
                user = setInfo(user);
                users.add(user);
                //testArraylist(users);
            }

            else{

            }
        }
    }

    private User setInfo(User user) {
        System.out.print("CPF: ");
        int cpf = input.nextInt();
        user.setCpf(cpf);

        System.out.print("Username: ");
        String username = input.nextLine();
        user.setUsername(username);
        input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        user.setPassword(password);

        return user;
    }

    public User setAuthority(int accountDecision, User user){
        if(accountDecision == 1){
            user = new Professor();
            user.setAuthorityLevel(1);
            return user;
        }
        else {
            user = new Student();
            user.setAuthorityLevel(2);
            return user;
        }
    }

    public void testArraylist(ArrayList<User> users){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i) != null) {
                System.out.println("User " + i + ": " + users.get(i).getAuthorityLevel());
            }
        }
    }
}
