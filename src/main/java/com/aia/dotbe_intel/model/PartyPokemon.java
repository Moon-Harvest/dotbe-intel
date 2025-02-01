package com.aia.dotbe_intel.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "party_pokemon_pool")
public class PartyPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private int canonicalPokemonId;
    @ManyToOne
    @JoinColumn
    private Party party;
    @ElementCollection
    @CollectionTable(name = "moveset")
    @Column(name = "move_id")
    private List<Integer> moveIds;

}
