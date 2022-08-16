package com.example.hw_tuesday.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor

public class Teacher {
    @NotNull(message = "Id can't be null")
    @Id
    private Integer id;
    @NotEmpty(message = "name can't be empty")
    private String name;
    @NotEmpty(message = "salary can't be empty")
    private Integer salary;
}
