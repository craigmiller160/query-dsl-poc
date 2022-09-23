package io.craigmiller160.querydsl.kotlin

import io.craigmiller160.querydslpoc.kotlin.data.repository.EmployeeRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
class JpaTest @Autowired constructor(
    private val employeeRepository: EmployeeRepository
) {
    @Test
    fun `get employees`() {
        val page = PageRequest.of(0, 1)
        val employees = employeeRepository.findAll(page)
        assertThat(employees.content).hasSize(1)
        val employee = employees.content.first()
        assertThat(employee.firstName.length).isGreaterThan(0)
    }
}