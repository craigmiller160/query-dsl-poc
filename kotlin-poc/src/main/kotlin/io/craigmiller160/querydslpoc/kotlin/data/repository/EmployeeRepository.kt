package io.craigmiller160.querydslpoc.kotlin.data.repository

import io.craigmiller160.querydslpoc.kotlin.data.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EmployeeRepository : JpaRepository<Employee, UUID>