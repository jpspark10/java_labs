package Tasks.EighthTask;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StudentTest {
    public static void studentCheck(){
        List<Student> students = getStudents();

        String targetFaculty = "ВМК";

        int targetBirthYear = 2000;



        System.out.println("\n1.1. Студенты с факультета " + targetFaculty + " (циклы):");
        for (Student student : students) {
            if (student.getFaculty().equals(targetFaculty)) {
                System.out.println(student);
            }
        }

        System.out.println("\n1.3. Студенты с факультета " + targetFaculty + " (Stream API):");
        students.stream()
                .filter(student -> student.getFaculty().equals(targetFaculty))
                .forEach(System.out::println);

        System.out.println("\n2.1. Списки студентов по факультетам и курсам (вложенные циклы):");
        for (String faculty : getUniqueFaculties(students)) {
            System.out.println("\nФакультет: " + faculty);
            for (int course = 1; course <= 5; course++) {
                for (Student student : students) {
                    if (student.getFaculty().equals(faculty) && student.getLearnCourse() == course) {
                        System.out.println(student);
                    }
                }
            }
        }

        System.out.println("\n2.3. Списки студентов по факультетам и курсам (Stream API):");
        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                        Collectors.mapping(student -> student, Collectors.toList())))
                .forEach((faculty, studentsOfFaculty) -> {
                    System.out.println("\nФакультет: " + faculty);
                    studentsOfFaculty.forEach(System.out::println);
                });

        System.out.println("\n3.1. Студенты, родившиеся после " + targetBirthYear + " года (циклы):");
        for (Student student : students) {
            if (student.getBirthDate().getYear() > targetBirthYear) {
                System.out.println(student);
            }
        }

        System.out.println("\n3.3. Студенты, родившиеся после " + targetBirthYear + " года (Stream API):");
        students.stream()
                .filter(student -> student.getBirthDate().getYear() > targetBirthYear)
                .forEach(System.out::println);
    }

    private static List<Student> getStudents() {
        Student[] studentsArray = new Student[]{
                new Student(1, "Иванов", "Иван", "Иванович", LocalDate.of(2000, 1, 1), "г. Москва", "+7(900)123-45-67", "ВМК", 4, 2),
                new Student(2, "Петров", "Петр", "Петрович", LocalDate.of(1998, 2, 2), "г. Санкт-Петербург", "+7(921)555-66-77", "ФизФак", 3, 1),
                new Student(3, "Сидоров", "Сидор", "Сидорович", LocalDate.of(2001, 3, 3), "г. Екатеринбург", "+7(343)222-33-44", "ВМК", 2, 3),
                new Student(4, "Кузнецов", "Кузьма", "Егорович", LocalDate.of(1999, 4, 4), "г. Новосибирск", "+7(812)444-55-66", "ФизФак", 4, 2),
                new Student(5, "Васильев", "Василий", "Васильевич", LocalDate.of(2002, 5, 5), "г. Казань", "+7(987)666-77-88", "ИИиТ", 1, 1),
        };

        return new ArrayList<>(Arrays.asList(studentsArray));
    }

    private static Set<String> getUniqueFaculties(List<Student> students) {
        Set<String> faculties = new HashSet<>();
        for (Student student : students) {
            faculties.add(student.getFaculty());
        }
        return faculties;
    }

    }

