package com.wybudujemydom.wd.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 4)
    @Column(unique = true)
    private String username;
    private String password;

    private String name;
    private String surname;
    @Enumerated(value = EnumType.STRING)

    private String city;
    @Enumerated(value = EnumType.STRING)
    private LocalDateTime creationDate;
    @Email
    private String email;

    private String phoneNumber;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

}
