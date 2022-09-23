package io.craigmiller160.querydslpoc.java;

import io.craigmiller160.querydslpoc.java.data.mapper.PositionMapper;
import io.craigmiller160.querydslpoc.java.data.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class MapStructTest {
    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    @Test
    public void test_mapStructMapper() {
        final var position = positionRepository.findAll().get(0);
        final var positionDto = positionMapper.positionToDTO(position);
        assertThat(positionDto)
                .hasFieldOrPropertyWithValue("id", position.getId())
                .hasFieldOrPropertyWithValue("name", position.getName());
    }
}
