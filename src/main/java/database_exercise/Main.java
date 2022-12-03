package database_exercise;

import java.util.Scanner;

import static database_exercise.StudentsList.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentsList studentsList=new StudentsList();
        boolean shouldContinue = true;

        while(shouldContinue) {
            System.out.println("1-Wyświetl grupę wg. nazwisk lub wieku / 2- usuń studenta z listy / 3-  Przejdź do innej grupy studentów / 4- dodaj nowego studenta / " +
                    "5-wyjdź z programu 6- Oceny 1-dodaj 2-wyświetl ocenę jednego studenta 3- wszystkie oceny");
            System.out.println("Wybierz swoją opcję: ");
            int userChoice = scanner.nextInt();
            System.out.println();

        switch (userChoice) {
            case 1:
                System.out.println("Wyświetl według: 1- nazwiska 2- wieku");
                int display = scanner.nextInt();
                if (display==1) {
                    displayStudentsBySurname();
                } else if (display==2) {
                    displayStudentsByAge();
                }
                break;
            case 2:
                removeStudent();
                break;
            case 3:
                studentsList=new StudentsList();
                System.out.println("Przeszedłeś do nowej grupy studentów.");
                break;
            case 4:
               addStudent();
               break;
            case 5:
                shouldContinue=false;
                break;
            case 6:
                System.out.println("1-dodaj ocenę 2-wyświetl oceny jdnego ucznia 3- wyświetl wszystkie oceny");
                int display2 = scanner.nextInt();
                if (display2==1) {
                    addMarks();
                } else if (display2==2) {
                    displayMarksByOne();
                } else if (display2==3) {
                    displayAllMarks();
                }
                break;
            default:
                System.out.println("Nie ma takiej opcji- spróbuj ponownie.");
        }
        }
        scanner.close();
    }
}