package database_exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

import static database_exercise.StudentsList.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentsList studentsList=new StudentsList();
        boolean shouldContinue = true;

        try {
            while (shouldContinue) {
                System.out.println("**********MENU**********");
                System.out.println("1. Wyświetl grupę");
                System.out.println("2. Dodaj studenta");
                System.out.println("3. Usuń studenta");
                System.out.println("4. Dział ocen studenta");
                System.out.println("5. Zakończ pracę nad bieżącą grupą- przejdź do nowej grupy");
                System.out.println("6. Wyjdź z programu");
                System.out.print("WPISZ SWOJĄ OPCJĘ: ");
                int userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1:
                        System.out.print("Wyświetl grupę według: 1.Nazwisk 2.Wieku. WPISZ SWOJĄ OPCJĘ: ");
                        int userChoice1 = scanner.nextInt();
                        System.out.println();
                        if (userChoice1 == 1) {
                            displayStudentsBySurname();
                        } else if (userChoice1 == 2) {
                            displayStudentsByAge();
                        } else {
                            System.out.println("NIE MA TAKIEJ OPCJI- SPRÓBUJ PONOWNIE\n");
                        }
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 4:
                        System.out.print("1.Dodaj ocenę. 2.Wyświetl oceny jednego studenta. 3.Wyświetl oceny całej grupy. WPISZ SWOJĄ OPCJĘ: ");
                        int userChoice2 = scanner.nextInt();
                        System.out.println();
                        if (userChoice2 == 1) {
                            addRating();
                        } else if (userChoice2 == 2) {
                            displayMarksByOne();
                        } else if (userChoice2 == 3) {
                            displayAllMarks();
                        } else {
                            System.out.println("NIE MA TAKIEJ OPCJI- SPRÓBUJ PONOWNIE\n");
                        }
                        break;
                    case 5:
                        studentsList = new StudentsList();
                        System.out.println("Przeszedłeś do nowej grupy studentów.\n");
                        break;
                    case 6:
                        shouldContinue = false;
                        break;
                    default:
                        System.out.println("\nNIE MA TAKIEJ OPCJI- SPRÓBUJ PONOWNIE\n");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\n**********Wybrano nieistniejącą opcję. Uruchom program raz jeszcze i zastosuj się do instrukcji**********\n");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}