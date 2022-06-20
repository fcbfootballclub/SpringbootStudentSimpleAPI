package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary_rate")
    private float salary_rate;
    @Column(name = "insurance")
    private float insurance;
}
