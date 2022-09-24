package io.craigmiller160.querydslpoc.java.data.repository;

import io.craigmiller160.querydslpoc.java.data.entity.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {}
