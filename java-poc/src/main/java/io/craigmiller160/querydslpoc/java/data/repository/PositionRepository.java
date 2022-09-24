package io.craigmiller160.querydslpoc.java.data.repository;

import io.craigmiller160.querydslpoc.java.data.entity.Position;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, UUID> {}
