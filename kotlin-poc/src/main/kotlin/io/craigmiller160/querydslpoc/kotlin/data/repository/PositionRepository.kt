package io.craigmiller160.querydslpoc.kotlin.data.repository

import io.craigmiller160.querydslpoc.kotlin.data.entity.Position
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface PositionRepository : JpaRepository<Position, UUID>
