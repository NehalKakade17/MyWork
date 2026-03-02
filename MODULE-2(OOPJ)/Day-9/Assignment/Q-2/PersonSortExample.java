package collectionsproblem;
import java.util.*;
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class PersonSortExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people-");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println("People name and age");
        for(int i =0;i<size;i++) {
        	System.out.println("Enter name:");
        	String name = sc.nextLine();
        	System.out.println("Enter age:");
        	int age = sc.nextInt();
        	sc.nextLine();
        	people.add(new Person(name,age));
        }
        Collections.sort(people, Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println("Sorted list of persons:");
        for (Person person : people) {
            System.out.println(person);
        }
        sc.close();
    }
}

