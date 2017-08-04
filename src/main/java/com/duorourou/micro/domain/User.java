package com.duorourou.micro.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String userId ;
    private String name;

}
