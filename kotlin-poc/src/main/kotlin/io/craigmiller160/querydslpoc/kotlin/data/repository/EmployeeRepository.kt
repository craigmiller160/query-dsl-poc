package io.craigmiller160.querydslpoc.kotlin.data.repository

import io.craigmiller160.querydslpoc.kotlin.data.entity.Employee
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, UUID>
