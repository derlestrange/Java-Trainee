package com.example.springsecurity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @Column(columnDefinition = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "surname")
    @NotBlank
    private String surname;

    @Column(name = "company")
    private String company;

    @Column(name = "salary")
    private int salary;

    @Column(name = "regtime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy HH:mm - EEEE")
    private LocalDateTime time;

    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "email")
    @NotBlank
    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User(@NotBlank String name, @NotBlank String surname, String company, int salary,
                LocalDateTime time, @NotBlank String password, @NotBlank String email) {
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.salary = salary;
        this.time = time;
        this.password = password;
        this.email = email;
    }
}
