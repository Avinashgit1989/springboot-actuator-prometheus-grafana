package com.learnwithak.userservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
}
