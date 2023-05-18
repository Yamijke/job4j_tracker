package ru.job4j.stream.atests;

import java.util.Arrays;
import java.util.List;

public class MapToInt {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );

        int sum = people.stream()
                .filter(p -> p.getAge() > 25)
                .mapToInt(Person::getAge)
                .peek(System.out::println)
                .sum();
        System.out.println("Сумма: " + sum);
    }
}
