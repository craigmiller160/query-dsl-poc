package io.craigmiller160.querydslpoc.java.data.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "positions")
public class Position {
  @Id private UUID id;
  private String name;
}
