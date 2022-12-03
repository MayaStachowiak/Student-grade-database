package database_exercise;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

@Getter
@Setter
public class Student implements  Comparable<Student>{

    @NonNull
    private String name, surname;
    @NonNull
    private int age;
    @NonNull
    private String city;
    @NonNull
    private int id;

    protected ArrayList<String> subjects;
    protected ArrayList<Integer> marks;

    public Student(@NonNull String name, @NonNull String surname, @NonNull int age, @NonNull String city, @NonNull int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.id = id;
        subjects = new ArrayList<>();
        marks = new ArrayList<>();
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name: " + name  +
                ", surname: " + surname +
                ", age: " + age +
                ", city: " + city +
                ", id: " + id +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.surname.compareTo(o.surname);
    }
}
