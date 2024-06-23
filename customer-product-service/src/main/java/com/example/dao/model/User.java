package com.example.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "User")
@Table(schema = "users", name = "User")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "f_name")
    String fName;

    @Column(name = "l_name")
    String lName;

    public User(Long id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public User(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public User() {

    }

    public User(User user) {
        this.id = user.id;
        this.fName = user.fName;
        this.lName = user.lName;
    }

    public User withId(Long id) {
        this.id = id;
        return this;
    }

    public User withFname(String fName) {
        this.fName = fName;
        return this;
    }
    public User withLname(String lName) {
        this.lName = lName;
        return this;
    }

    public User build() {
        return new User(this);
    }

    public User updateUser(User newUser, User oldUser) {
        return new User(newUser.getfName(), newUser.getlName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
