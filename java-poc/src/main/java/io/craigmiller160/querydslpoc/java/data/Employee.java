package io.craigmiller160.querydslpoc.java.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "employees")
public class Employee {
  @Id private UUID id;
  private String firstName;
  private String lastName;
  private LocalDate dateOfBirth;
  private UUID positionId;
}
