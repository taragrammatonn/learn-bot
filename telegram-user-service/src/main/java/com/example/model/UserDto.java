package com.example.model;

public class UserDto {

    private Long id;

    private String userName;
    private String fName;

    private String lName;
    public UserDto(Long id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public UserDto(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public UserDto() {

    }

    public UserDto(UserDto user) {
        this.id = user.id;
        this.fName = user.fName;
        this.lName = user.lName;
    }

    public UserDto(Long id, String fName, String lName, String userName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
    }

    public UserDto withId(Long id) {
        this.id = id;
        return this;
    }

    public UserDto withFname(String fName) {
        this.fName = fName;
        return this;
    }
    public UserDto withLname(String lName) {
        this.lName = lName;
        return this;
    }

    public UserDto build() {
        return new UserDto(this);
    }

    public UserDto updateUser(UserDto newUser, UserDto oldUser) {
        return new UserDto(newUser.getfName(), newUser.getlName());
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
