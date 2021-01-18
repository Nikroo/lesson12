package by.itacademy;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private LocalDate date;

    public Person(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
