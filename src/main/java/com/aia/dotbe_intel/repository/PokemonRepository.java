package com.aia.dotbe_intel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aia.dotbe_intel.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findByName(String name); 
}
