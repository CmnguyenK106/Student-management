package vn.edu.hcmut.cse.adsoftweng.lab.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student {
    @Id
    private String Id;
    private String name;
    private String email;
    private int age;

    public Student() {
    }

    public Student(String id, String name, String email, int age) {
        Id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}