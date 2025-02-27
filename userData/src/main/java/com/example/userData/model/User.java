package com.example.userData.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date birthday;

    private String email;

    private String content;

    public User(String name, Date birthday, String email, String content) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.content = content;
    }

}
