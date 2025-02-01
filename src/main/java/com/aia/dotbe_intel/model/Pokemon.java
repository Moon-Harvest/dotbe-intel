package com.aia.dotbe_intel.model;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pokedex")
public class Pokemon {

    @Id
    private int canonicalId;
    private String canonicalName;
    @Enumerated(EnumType.STRING)
    private Type type1;
    @Enumerated(EnumType.STRING)
    @Nullable
    private Type type2;
    private int generation;

}
