package com.macina.itevent.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
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
}
