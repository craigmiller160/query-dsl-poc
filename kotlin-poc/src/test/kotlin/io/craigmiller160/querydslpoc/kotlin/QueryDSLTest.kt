package io.craigmiller160.querydslpoc.kotlin

import io.craigmiller160.querydslpoc.kotlin.service.QueryDSLService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
class QueryDSLTest @Autowired constructor(
    private val queryDSLService: QueryDSLService
) {
    @Test
    fun `query dsl operation`() {
        val result = queryDSLService.getOneEmployee()
        assertNotNull(result)
    }
}