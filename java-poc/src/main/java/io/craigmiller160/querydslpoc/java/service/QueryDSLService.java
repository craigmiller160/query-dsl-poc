package io.craigmiller160.querydslpoc.java.service;

import com.querydsl.jpa.JPQLQueryFactory;
import io.craigmiller160.querydslpoc.java.data.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryDSLService {
    private final JPQLQueryFactory queryFactory;

    public Optional<Employee> getOneEmployee() {
        final var nullableResult = queryFactory.query()
                .from(QEmployee.employee)
                .limit(1)
                .fetchFirst();
        return Optional.ofNullable(nullableResult);
    }
}
