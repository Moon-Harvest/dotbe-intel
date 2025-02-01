package com.aia.dotbe_intel.service;

import com.aia.dotbe_intel.model.Party;
import com.aia.dotbe_intel.repository.PartyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PartyService {

    private final PartyRepository pokemonPartyPoolRepository;

    public void createParty(String partyName) {
        pokemonPartyPoolRepository.save(new Party(partyName));
    }



}
