package database_exercise;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;

import java.util.*;
import java.util.stream.Collectors;



public class StudentsList {

    public static ArrayList<Student> students;
    private static Scanner scanner = new Scanner(System.in);

    public StudentsList() {

        students = new ArrayList<>();
        Faker faker = new Faker(new Locale("pl"));
        Name name = faker.name();
        Number number = faker.number();
        Address address = faker.address();

        for (int i = 0; i < 5; i++) {
            students.add(new Student(name.firstName(), name.lastName(), number.numberBetween(18, 26),
                    address.city(), number.numberBetween(463456, 785654)));
        }

    }


    public static void DisplayStudentsBySurname() {
        students.sort((s1, s2) -> s1.getSurname().compareTo(s2.getSurname()));
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static void DisplayStudentsByAge() {
        students.sort((s1, s2) -> s1.getAge() - s2.getAge());
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }


    public static void RemoveStudent() {
        System.out.print("Wpisz ID studenta: ");
        int studentId = scanner.nextInt();

        Set<Student> studentToRemove = students.stream()
                        .filter(mapping -> mapping.getId() == (studentId))
                        .collect(Collectors.toSet());



        if (!studentToRemove.isEmpty()) {

            System.out.println(studentToRemove);
            Student student = students.stream()
                    .filter(mapping -> mapping.getId() == (studentId))
                    .findFirst()
                    .get();

            students.remove(student);
            System.out.println("Student został pomyślnie usunięty z listy.\n");
        } else {
            System.out.println("Student o podanym ID nie istnieje w bazie danych.\n");
        }


    }
}






