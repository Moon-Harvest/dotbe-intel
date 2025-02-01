package com.aia.dotbe_intel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "typing_chart")
public class TypeEffectiveness {
    @Id
    private String name;
    private double normal;
    private double fire;
    private double water;
    private double electric;
    private double grass;
    private double ice;
    private double fighting;
    private double poison;
    private double ground;
    private double flying;
    private double psychic;
    private double bug;
    private double rock;
    private double ghost;
    private double dragon;
    private double dark;
    private double steel;
    private double fairy;
}
