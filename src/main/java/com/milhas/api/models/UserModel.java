package com.milhas.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity()
@Table(name = "TB_USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String gender;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name  = "state_id", nullable = false)
    private StateModel state;
    public UserModel(String name, String dateOfBirth, String document,
                     String email, String phoneNumber, String password, String gender,
                     String city, StateModel state){

        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter).atStartOfDay();
        this.document = document;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.gender = gender;
        this.city = city;
        this.state = state;
    }

}
