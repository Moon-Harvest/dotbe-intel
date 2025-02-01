package com.aia.dotbe_intel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aia.dotbe_intel.model.Move;

public interface MoveRepository extends JpaRepository<Move, Integer> {
    Optional<Move> findByName(String name);
}
