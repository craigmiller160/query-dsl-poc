package io.craigmiller160.querydslpoc.java.data.repository;

import io.craigmiller160.querydslpoc.java.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, UUID>, JpaRepository<Employee, UUID> {}
