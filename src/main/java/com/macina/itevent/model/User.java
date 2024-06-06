package com.macina.itevent.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private String role;
    @Nullable
    private LocalDate birthdate;
    @Nullable
    private String lastjob;
    @Nullable
    private String lastcompany;
    @Nullable
    private Integer age;

    public User(String name, String lastname, String email, String role,
                @Nullable LocalDate birthdate, @Nullable String lastjob, @Nullable String lastcompany,
                @Nullable Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.birthdate = birthdate;
        this.lastjob = lastjob;
        this.lastcompany = lastcompany;
        this.age = calculateAge(this.birthdate);
    }

    private Integer calculateAge(LocalDate birthDate){
        if(birthDate != null){
            return Period.between(birthDate,LocalDate.now()).getYears();
        }
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Nullable
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(@Nullable LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Nullable
    public String getLastjob() {
        return lastjob;
    }

    public void setLastjob(@Nullable String lastjob) {
        this.lastjob = lastjob;
    }

    @Nullable
    public String getLastcompany() {
        return lastcompany;
    }

    public void setLastcompany(@Nullable String lastcompany) {
        this.lastcompany = lastcompany;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge() {
        this.age = calculateAge(this.birthdate);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", birthdate=" + birthdate +
                ", lastjob='" + lastjob + '\'' +
                ", lastcompany='" + lastcompany + '\'' +
                ", age=" + age +
                '}';
    }
}
