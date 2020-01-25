package main;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.ExceptionManagement;
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
    ExceptionManagement exception = new ExceptionManagement();
    LoggedPage login = new LoggedPage();
    int id = -1;

    public void Init(){
        while(true){
            text.mainOptions();
            int choice = exception.scanInt("Type here: ");

            if(choice == 0){
                System.out.println("\nClosing the system.");
                return;
            }

            else if(choice == 1){
                text.creatingOptions();
                choice = exception.scanInt("Type here: ");
                id++;
                user = setAuthority(choice, user);
                user = setInfo(user);
                users.add(user);
                //testArraylist(users);

                System.out.println("You succesfully created an account.");
            }

            else{
                int cpf = exception.scanInt("CPF: ");
                System.out.print("Password: ");
                String password = input.nextLine();

                int userId = searchUser(cpf, password, users);
                if (userId == -1){
                    System.out.println("User does not exist.");
                    break;
                }

                System.out.println("Username: " + users.get(userId).getUsername());
                if (users.get(userId).getAuthorityLevel() == 1){
                    System.out.println("You are a professor.");
                }
                else{
                    System.out.println("You are a student.");
                }

                login.loginPage(users, userId);

            }
        }
        Init();
    }

    public int searchUser(int cpf, String password, ArrayList<User> users) {
        for (User c: users) {
            if (c != null){
                if (c.getCpf() == cpf && c.getPassword().equals(password)){
                    System.out.println("Login was done.\n");
                    return c.getId();
                }
            }
        }
        return -1;
    }//TODO Tentar passar para User, ou criar classe abstrata para User, professor e student

    private User setInfo(User user) {
        user.setId(id);

        int cpf = exception.scanInt("CPF: ");
        user.setCpf(cpf);
        System.out.print("Username: ");
        String username = input.nextLine();
        user.setUsername(username);
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
