package Tasks.EighthTask;

import java.time.LocalDate;

public class Student {
    private int id;
    private String fam;
    private String name;
    private String dadName;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int learnCourse;
    private int group;

    // Конструкторы
    public Student(int id, String fam, String name, String dadName, LocalDate birthDate, String address, String phoneNumber, String faculty, int learnCourse, int group) {
        this.id = id;
        this.fam = fam;
        this.name = name;
        this.dadName = dadName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.learnCourse = learnCourse;
        this.group = group;
    }

    public Student(String fam, String name, String dadName, LocalDate birthDate, String address, String phoneNumber, String faculty, int learnCourse, int group) {
        this(0, fam,name,dadName,birthDate,address,phoneNumber,faculty,learnCourse,group);
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDadName() {
        return dadName;
    }

    public void setDadName(String dadName) {
        this.dadName = dadName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getLearnCourse() {
        return learnCourse;
    }

    public void setLearnCourse(int learnCourse) {
        this.learnCourse = learnCourse;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    // Метод toString()
    @Override
    public String toString() {
        return "Студент{" +
                "id=" + id +
                ", фамилия='" + fam + '\'' +
                ", имя='" + name + '\'' +
                ", отчество='" + dadName + '\'' +
                ", датаРождения=" + birthDate +
                ", адрес='" + address + '\'' +
                ", телефон='" + phoneNumber + '\'' +
                ", факультет='" + faculty + '\'' +
                ", курс=" + learnCourse +
                ", группа=" + group +
                '}';
    }
}

