package io.craigmiller160.querydslpoc.kotlin.service

import com.querydsl.jpa.impl.JPAQueryFactory
import io.craigmiller160.querydslpoc.kotlin.data.entity.Employee
import io.craigmiller160.querydslpoc.kotlin.data.entity.QEmployee
import org.springframework.stereotype.Service

@Service
class QueryDSLService(private val queryFactory: JPAQueryFactory) {
  fun getOneEmployee(): Employee? =
    queryFactory.query().from(QEmployee.employee).limit(1).select(QEmployee.employee).fetchFirst()
}
