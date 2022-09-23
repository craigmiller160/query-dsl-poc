package io.craigmiller160.querydslpoc.java.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "positions")
public class Position {
  @Id private UUID id;
  private String name;
}
