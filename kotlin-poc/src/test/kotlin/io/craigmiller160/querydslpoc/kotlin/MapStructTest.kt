package io.craigmiller160.querydslpoc.kotlin

import io.craigmiller160.querydslpoc.kotlin.data.mapper.PositionMapper
import io.craigmiller160.querydslpoc.kotlin.data.repository.PositionRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
class MapStructTest @Autowired constructor(
    private val positionRepository: PositionRepository,
    private val positionMapper: PositionMapper
) {
    @Test
    fun `map struct mapper`() {
        TODO()
    }
}