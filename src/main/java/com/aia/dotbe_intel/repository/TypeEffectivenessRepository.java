package com.aia.dotbe_intel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aia.dotbe_intel.model.TypeEffectiveness;

public interface TypeEffectivenessRepository extends JpaRepository<TypeEffectiveness, String>{

    Optional<TypeEffectiveness> findByName(String string);

}
