package Tasks.SeventhTask;

import java.util.List;

public class Client {

    private int id;
    private String name;
    private int age;
    private List<Phone> phones;

    public Client(int id, String name, int age, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public static class Phone {
        private String number;
        private PhoneType type;

        public Phone(String number, PhoneType type) {
            this.number = number;
            this.type = type;
        }

        public String getNumber() {
            return number;
        }

        public PhoneType getType() {
            return type;
        }

        public enum PhoneType {
            MOBILE, LANDLINE
        }
    }

}