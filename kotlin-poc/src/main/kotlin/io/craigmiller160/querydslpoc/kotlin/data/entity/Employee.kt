package io.craigmiller160.querydslpoc.kotlin.data.entity

import java.time.LocalDate
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "employees")
class Employee {
    @Id
    lateinit var id: UUID
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var dateOfBirth: LocalDate
    lateinit var positionId: UUID
}