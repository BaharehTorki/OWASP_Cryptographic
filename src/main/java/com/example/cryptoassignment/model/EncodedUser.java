package com.example.cryptoassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@ToString
@Entity
@Getter
public class EncodedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int age;
    private String name;
    private String password;

    public EncodedUser() {
    }

    public EncodedUser(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = getEncode(password);
    }


    private String getEncode(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
