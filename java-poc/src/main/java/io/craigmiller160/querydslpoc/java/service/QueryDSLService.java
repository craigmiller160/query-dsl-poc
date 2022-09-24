package io.craigmiller160.querydslpoc.java.service;

import com.querydsl.jpa.JPQLQueryFactory;
import io.craigmiller160.querydslpoc.java.data.entity.Employee;
import io.craigmiller160.querydslpoc.java.data.entity.QEmployee;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryDSLService {
  private final JPQLQueryFactory queryFactory;

  public Optional<Employee> getOneEmployee() {
    final Employee nullableResult =
        queryFactory
            .query()
            .from(QEmployee.employee)
            .limit(1)
            .select(QEmployee.employee)
            .fetchFirst();
    return Optional.ofNullable(nullableResult);
  }
}
