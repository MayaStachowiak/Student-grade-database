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
    private static HashMap <String, List <Integer>> subjectGrades = new HashMap<>();
    private static String subject;
    private static int mark;

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
        String name = scanner.nextLine();
        System.out.print("Nazwisko ");
        String surname = scanner.nextLine();
        System.out.print("Miasto urodzenia: ");
        String city = scanner.nextLine();
        System.out.print("Wiek: ");
        int age = scanner.nextInt();
        System.out.print("6 cyfrowy numer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(name, surname,age, city, id);
        students.add(student);
        System.out.println("Nowy student dodany do bazy.");
        System.out.println();
    }

    public static void displayStudentsBySurname() {
        students.sort(Comparator.comparing(Student::getSurname));
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static void displayStudentsByAge() {
        students.sort(Comparator.comparingInt(Student::getAge));
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static void addRating () {

        Set<Student> studentsSet = new HashSet<>(students);
        System.out.print("Wpisz ID studenta: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Optional<Student> student = Optional.ofNullable(studentsSet.stream()
                .filter(mapping -> mapping.getId() == (studentId))
                .findFirst()
                .orElse(null));

        if (student.isPresent()) {
            System.out.println(student.get().getName() + " " + student.get().getSurname() + " " + student.get().getId() + "\n");

            System.out.print("Wpisz przedmiot: ");
            subject = scanner.nextLine();
            System.out.print("Wpisz liczbę punktów: ");
            mark = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ocena została dodana.");
            System.out.println();

            if (student.get().subjectGrades.containsKey(subject)) {
                student.get().subjectGrades.get(subject).add(mark);
            } else {
                student.get().subjectGrades.put(subject, new ArrayList<>(Arrays.asList(mark)));
            }
        } else {
            System.out.println("Student nie istnieje w bazie.\n");
        }
        }

    public static void displayMarksByOne () {
        Set<Student> studentsSet = new HashSet<>(students);
        System.out.print("Wpisz ID studenta którego oceny chcesz zobaczyć: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        Optional<Student> student = Optional.ofNullable(studentsSet.stream()
                .filter(mapping -> mapping.getId() == (studentId))
                .findFirst()
                .orElse(null));

        if (student.isPresent()) {
            System.out.println(student.get().getName() + " " + student.get().getSurname() + " " + student.get().getId());
            student.get().subjectGrades.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);
        } else {
            System.out.println("Student nie istnieje w bazie.\n");

        }
        System.out.println();
       }

    public static void displayAllMarks () {
        students.sort(Comparator.comparing(Student::getSurname));

        for (int i =0; i< students.size(); i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getSurname() + "\tID: " + students.get(i).getId());

            if (students.get(i).subjectGrades.isEmpty()) {
                System.out.println("[Lista ocen studenta jest pusta]");
            } else {
                for (Map.Entry<String, List<Integer>> me : students.get(i).subjectGrades.entrySet()) {
                    List<Integer> valueList = me.getValue();
                    System.out.print("Przedmiot: " + me.getKey());
                    System.out.print("\tOceny: ");
                    for (Integer in : valueList) {
                        System.out.print(in + " ");
                    }
                    System.out.println();
                }
            }
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
            System.out.println("Student został pomyślnie usunięty z bazy.\n");
        } else {
            System.out.println("Student o podanym ID nie istnieje w bazie danych.\n");
        }
    }
}






