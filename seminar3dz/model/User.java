package seminar3dz.model;

import java.util.*;

public class User {
    private String name;
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthdate;
    private Long telNumber;
    private Character gender;

    public User(String name,Date birthdate, Long telNumber, Character gender) {
        this.name = name;
        this.firstName = name.split(" ")[0];
        this.secondName = name.split(" ")[1];
        this.lastName = name.split(" ")[2];
        this.birthdate = birthdate;
        this.telNumber = telNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public Character getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", firstName=" + firstName + ", secondName=" + secondName + ", lastName="
                + lastName + ", birthdate=" + birthdate + ", telNumber=" + telNumber + ", gender=" + gender + "]";
    }

    
    
}
