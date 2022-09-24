package io.craigmiller160.querydslpoc.java;

import static org.assertj.core.api.Assertions.assertThat;

import io.craigmiller160.querydslpoc.java.data.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class LombokAndJpaTest {
  private final EmployeeRepository employeeRepository;

  @Test
  public void test_getEmployeesAndValidateLombokProperties() {
    final var page = PageRequest.of(0, 1);
    final var employees = employeeRepository.findAll(page);
    assertThat(employees.getContent()).hasSize(1);
    final var employee = employees.getContent().get(0);
    assertThat(employee.getFirstName()).isNotNull();
  }
}
