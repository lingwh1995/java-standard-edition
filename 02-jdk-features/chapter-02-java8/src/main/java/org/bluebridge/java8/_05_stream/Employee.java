package org.bluebridge.java8._05_stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@Data
public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private BigDecimal salary;
}
