package com.example.quesapptwo.entities;

import lombok.Data;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Data
public class User {
    @Id
    Long id;
    String userName;
    String password;


}