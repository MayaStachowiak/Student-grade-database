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

    public static void addStudent() {

        System.out.println("Wpisz dane nowego studenta.");
        System.out.print("Imię: ");
        String name = (scanner.next()) + scanner.nextLine();
        System.out.print("Nazwisko ");
        String surname = scanner.nextLine();
        System.out.print("Miasto urodzenia: ");
        String city = scanner.next();
        System.out.print("Wiek: ");
        int age = scanner.nextInt();
        System.out.print("6 cyfrowy numer ID: ");
        int id = scanner.nextInt();


        Student student = new Student(name, surname,age, city, id);
        students.add(student);
    }

    public static void displayStudentsBySurname() {
        students.sort((s1, s2) -> s1.getSurname().compareTo(s2.getSurname()));
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static void displayStudentsByAge() {
        students.sort((s1, s2) -> s1.getAge() - s2.getAge());
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static void addMarks () {
        Set<Student> studentsSet = new HashSet<>(students);
        System.out.print("Wpisz ID studenta: ");
        int studentId = scanner.nextInt();

        Student student = studentsSet.stream()
                .filter(mapping -> mapping.getId() == (studentId))
                .findFirst()
                .get();

        System.out.println("Wpisz przedmiot: ");
        String subject = scanner.next() + scanner.nextLine();
        System.out.println("Wpisz liczbę punktów: ");
        int mark = scanner.nextInt();
        student.subjects.add(subject);
        student.marks.add(mark);


    }
    public static void displayMarksByOne () {
        Set<Student> studentsSet = new HashSet<>(students);
        System.out.print("Wpisz ID studenta którego oceny chcesz zobaczyć: ");
        int studentId = scanner.nextInt();

        Student student = studentsSet.stream()
                .filter(mapping -> mapping.getId() == (studentId))
                .findFirst()
                .get();

        System.out.println(student.getName() + " " + student.getSurname() + " OCENY: ");
        System.out.println(student.getSubjects() + " " + student.getMarks());

    }
    public static void displayAllMarks () {
        students.sort((s1, s2) -> s1.getSurname().compareTo(s2.getSurname()));

        for (int i =0; i< students.size(); i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getSurname());
            System.out.println(students.get(i).getSubjects() + " " + students.get(i).getMarks());
            System.out.println();
        }
        }



    public static void removeStudent() {
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






