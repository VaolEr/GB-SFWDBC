package ru.geekbrains.VaolEr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Customer")
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    String id;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    String firstName;

    @NotBlank
    @Column(name = "lastName", nullable = false)
    String lastName;

    @NotBlank
    @Column(name = "city", nullable = false)
    String city;
}
