package ThirdTask;

import java.util.*;

public class HumanTest {
    public static void humanTest() {
        System.out.println("\n---Third task---\n");

        System.out.println("a) HashSet");
        Set<Human> s = new HashSet<>();
        s.add(new Human("Иван", "Петров", 25));
        s.add(new Human("Мария", "Сидорова", 30));
        s.add(new Human("Андрей", "Иванов", 20));
        s.add(new Human("Петр", "Васильев", 40));
        s.add(new Human("Анна", "Кузнецова", 35));

        for (Human human : s) {
            System.out.println(human);
        }

        System.out.println("b) LinkedHashSet");
        Set<Human> linkedHashSet = new LinkedHashSet<>(s);


        for (Human human : linkedHashSet) {
            System.out.println(human);
        }

        System.out.println("c) TreeSet");
        Set<Human> treeSet = new TreeSet<>(s);


        for (Human human : treeSet) {
            System.out.println(human);
        }

        System.out.println("d) TreeSet с компаратором HumanComparatorByLName");
        TreeSet<Human> treeSetByLName = new TreeSet<>(new HumanComparatorByLName());
        treeSetByLName.addAll(s);


        for (Human human : treeSetByLName) {
            System.out.println(human);
        }

        System.out.println( "e) TreeSet с анонимным компаратором по возрасту");
        TreeSet<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        treeSetByAge.addAll(s);


        for (Human human : treeSetByAge) {
            System.out.println(human);
        }
    }
}
