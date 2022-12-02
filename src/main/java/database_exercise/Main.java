package database_exercise;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static database_exercise.StudentsList.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentsList studentsList=new StudentsList();
        boolean shouldContinue = true;



        while(shouldContinue) {
            System.out.println("1- stwórz całkiem nową listę/ 2- Wyświetl(wg. nazwisk lub wieku /3- usuń studenta z listy / 4-wyjście z programu");
            System.out.println("Wybierz swoją opcję: ");
            int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                studentsList=new StudentsList();
                System.out.println("Nowa lista została stworzona");
                break;
            case 2:
                System.out.println("Wyświetl po: 1- nazwisku 2- wieku");
                int display = scanner.nextInt();
                if (display==1) {
                    DisplayStudentsBySurname();
                } else if (display==2) {
                    DisplayStudentsByAge();
                }
                break;
            case 3:
                RemoveStudent();
                break;
            case 4:
               shouldContinue=false;
               break;
        }

        }


    }
}