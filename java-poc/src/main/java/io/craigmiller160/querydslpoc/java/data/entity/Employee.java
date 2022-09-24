package io.craigmiller160.querydslpoc.java.data.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

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
