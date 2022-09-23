package io.craigmiller160.querydslpoc.kotlin

import io.craigmiller160.querydslpoc.kotlin.data.mapper.PositionMapper
import io.craigmiller160.querydslpoc.kotlin.data.repository.PositionRepository
import org.assertj.core.api.Assertions.assertThat
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
        val position = positionRepository.findAll().first()
        val positionDto = positionMapper.positionToDTO(position)
        assertThat(positionDto)
            .hasFieldOrPropertyWithValue("id", position.id)
            .hasFieldOrPropertyWithValue("name", position.name);
    }
}