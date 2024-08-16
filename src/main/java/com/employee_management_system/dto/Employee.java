package com.employee_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 long id;
 String first;
 String last;
 String email;
 long mobile;
}
