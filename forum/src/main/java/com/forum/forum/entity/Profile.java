package com.forum.forum.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Profile")
@Table(name = "profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "profiles")
    private List<User> users;
}
