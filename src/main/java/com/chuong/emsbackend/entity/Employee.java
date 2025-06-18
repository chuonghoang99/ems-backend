package com.chuong.emsbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @Size(min = 2, max = 50, message = "{employee.size.invalid}")
    private String name;

    @Column(unique = true, nullable = false)
    @Email(message = "{employee.email.invalid}")
    private String email;
}
