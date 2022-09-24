package io.craigmiller160.querydslpoc.kotlin.data.mapper

import io.craigmiller160.querydslpoc.kotlin.data.dto.PositionDTO
import io.craigmiller160.querydslpoc.kotlin.data.entity.Position
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PositionMapper {
  fun positionToDTO(position: Position): PositionDTO
}
