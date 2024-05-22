
public class MainPeregruzka {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.displayInfo();

        Person person2 = new Person("Катя");
        person2.displayInfo();

        Person person3 = new Person("Иван", 30);
        person3.displayInfo();
    }
}


class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Неопознанный объект";
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        if(age == 0){
            System.out.println("Имя: " + name);
        } else{
            System.out.println("Имя: " + name + ", Возраст: " + age);
        }
    }
}
