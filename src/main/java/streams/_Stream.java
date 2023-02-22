package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
//                new Person("Alex", NONBINARY),
                new Person("Alice", FEMALE)
        );

//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//
//        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = String::length;
//        IntConsumer println = System.out::println;
//        people.stream()
//                .map(personStringFunction)
//                .mapToInt(length)
//                .forEach(println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

        boolean noNonBinary = people.stream()
                .noneMatch(person -> NONBINARY.equals(person.gender));

        System.out.println(noNonBinary);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return name + " " + gender.toString();
        }
    }

    enum Gender {
        MALE, FEMALE, NONBINARY
    }
}
