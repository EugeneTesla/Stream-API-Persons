package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }


        Stream<Person> streamOne = persons.stream();
        System.out.println(persons.stream().filter((s)-> s.getAge() < 18).count());

        Stream<Person> streamTwo = persons.stream();
        System.out.println(persons.stream().filter((s)-> s.getAge() >= 18 && s.getAge() < 27 && s.getSex() == Sex.MAN)
                            .map(Person::getFamily).collect(Collectors.toList()));

        Stream<Person> streamThree = persons.stream();
        System.out.println(persons.stream()
                        .filter((s)-> (s.getAge() >= 18 && s.getAge() < 59 && s.getSex() == Sex.WOMAN) || (s.getAge() >= 18 && s.getAge() < 64 && s.getSex() == Sex.MAN))
                        .map(s -> s.getFamily())
                        .sorted()
                        .collect(Collectors.toList()));




    }


}
