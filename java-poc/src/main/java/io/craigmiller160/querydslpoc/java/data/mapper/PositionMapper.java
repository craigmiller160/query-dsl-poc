package io.craigmiller160.querydslpoc.java.data.mapper;

import io.craigmiller160.querydslpoc.java.data.dto.PositionDTO;
import io.craigmiller160.querydslpoc.java.data.entity.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PositionMapper {
  PositionDTO positionToDTO(final Position position);
}
