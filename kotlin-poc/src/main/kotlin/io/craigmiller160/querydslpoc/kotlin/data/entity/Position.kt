package io.craigmiller160.querydslpoc.kotlin.data.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "positions")
class Position {
  @Id lateinit var id: UUID
  lateinit var name: String
}
