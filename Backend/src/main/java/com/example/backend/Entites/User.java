package com.example.backend.Entites;

import com.example.backend.Entites.Enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    private String username;
    private String email;
    private String password;
    private String image;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private String verificationToken;
    private boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Evaluation> evaluations;
}
