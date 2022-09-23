package io.craigmiller160.querydslpoc.java.data.repository;

import io.craigmiller160.querydslpoc.java.data.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<Position, UUID> {}
