package profile;

import command.Command;
import command.Option;
import exceptions.ExceptionManagement;
import student.Student;
import texts.TextOptions;
import user.User;
import professor.Professor;

import java.util.ArrayList;
import java.util.Scanner;

public class ProfileManagement extends Option implements Command {
        TextOptions text = new TextOptions();
        Scanner entry = new Scanner(System.in);
        ExceptionManagement exception = new ExceptionManagement();

        @Override
        public void execute(ArrayList<User> users, int userId, Option option){
                text.profileOptions();
                int choice = exception.scanInt("Type here: ");
                if (choice == 1){
                        createProfile(users, userId);
                }
                else if (choice == 2){
                        editProfile(users, userId);
                }
                else if (choice == 3){
                        checkProfile(users, userId);
                }
                else return;
        }

        private void createProfile(ArrayList<User> users, int userId) {
                Scanner profileEntry = new Scanner(System.in);
                System.out.print("Insert your full name: ");
                users.get(userId).setFullName(profileEntry.nextLine());
                users.get(userId).setAge(exception.scanInt("Insert your age: "));
                System.out.print("Insert your e-mail: ");
                users.get(userId).setEmail(profileEntry.nextLine());

                if (users.get(userId).getAuthorityLevel() == 1){
                        ((Professor) users.get(userId)).setClassesQuantity(exception.scanInt("Insert how many classes you have: "));
                        System.out.print("Insert your formation: ");
                        ((Professor) users.get(userId)).setFormation(profileEntry.nextLine());
                        System.out.print("Insert your specialization area: ");
                        ((Professor) users.get(userId)).setSpecialization(profileEntry.nextLine());
                }
                if (users.get(userId).getAuthorityLevel() == 2){
                        ((Student) users.get(userId)).setRegistrationNumber(exception.scanInt("Insert your registration number: "));
                        System.out.print("Insert your University course: ");
                        ((Student) users.get(userId)).setUniversityDiscipline(profileEntry.nextLine());
                        ((Student) users.get(userId)).setUniversityPeriod(exception.scanInt("Insert your Course period: "));
                        ((Student) users.get(userId)).setIngressionYear(exception.scanInt("Insert your ingression year: "));
                }
        }

        private void editProfile(ArrayList<User> users, int userId) {
                text.profileChangeOptions();

                if (users.get(userId).getAuthorityLevel() == 2) { System.out.println("5 to Registration number"); }
                else text.professorProfileChangeOptions();

                int decision = exception.scanInt("Type here: ");
                if (decision == 0) return;
                else if (decision == 1){
                        System.out.print("Type here: ");
                        entry.nextLine();
                        users.get(userId).setFullName(entry.nextLine());
                }
                else if (decision == 2){ users.get(userId).setAge(exception.scanInt("Type here: ")); }
                else if (decision == 3){
                        System.out.print("Type here: ");
                        users.get(userId).setEmail(entry.nextLine());
                }
                else if (decision == 4){
                        System.out.print("Type here: ");
                        users.get(userId).setUsername(entry.nextLine());
                }

                if (users.get(userId).getAuthorityLevel() == 2)
                        if (decision == 5) ((Student) users.get(userId)).setRegistrationNumber(exception.scanInt("Type here: "));
                if (users.get(userId).getAuthorityLevel() == 1){
                        if (decision == 5) ((Professor) users.get(userId)).setClassesQuantity(exception.scanInt("Type here: "));
                        entry.nextLine();
                        if (decision == 6) {
                                System.out.print("Type here: ");
                                ((Professor) users.get(userId)).setFormation(entry.nextLine());
                        }
                        else if (decision == 7) {
                                System.out.print("Type here: ");
                                ((Professor) users.get(userId)).setSpecialization(entry.nextLine());
                        };
                }
                System.out.println();
        }

        private void checkProfile(ArrayList<User> users, int userId) {
                System.out.println("Do you want to see your informations ? [Yes / No]");
                String decision = entry.next();
                if (decision.equalsIgnoreCase("Yes")){

                        System.out.print("\nFull name: ");
                        System.out.println(users.get(userId).getFullName());//
                        System.out.print("Age: ");
                        if (users.get(userId).getAuthorityLevel() == 1){
                                if (users.get(userId).getAge() < 25)
                                        System.out.println("Lower than 25.");
                                else
                                        System.out.println(users.get(userId).getAge());
                        }
                        if (users.get(userId).getAuthorityLevel() == 2){
                                if (users.get(userId).getAge() < 18)
                                        System.out.println("Lower than 18.");
                                else
                                        System.out.println(users.get(userId).getAge());
                        }

                        System.out.print("E-mail: ");
                        System.out.println(users.get(userId).getEmail());//

                        if (users.get(userId).getAuthorityLevel() == 2) {
                                System.out.print("Registration number: ");
                                System.out.println((((Student) users.get(userId))).getRegistrationNumber());
                                System.out.print("Ingression year: ");
                                System.out.println((((Student) users.get(userId))).getIngressionYear());
                                System.out.print("University course: ");
                                System.out.println((((Student) users.get(userId))).getUniversityDiscipline());
                                System.out.print("University period: ");
                                System.out.println((((Student) users.get(userId))).getUniversityPeriod());
                                System.out.println();
                        }
                        else{
                                System.out.print("Number of classes: ");
                                System.out.println(((Professor) users.get(userId)).getClassesQuantity());
                                System.out.print("Formation: ");
                                System.out.println(((Professor) users.get(userId)).getFormation());
                                System.out.print("Insert your specialization: ");
                                System.out.println(((Professor) users.get(userId)).getSpecialization());
                                System.out.println();
                        }
                }
                else return;
        }
}
