package com.aia.dotbe_intel.service.import_services;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.aia.dotbe_intel.model.Pokemon;
import com.aia.dotbe_intel.model.Type;
import com.aia.dotbe_intel.repository.PokemonRepository;
import com.opencsv.CSVReader;

import jakarta.transaction.Transactional;

@Service
public class PokedexImportService {

    private final PokemonRepository pokemonRepository;

    public PokedexImportService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Transactional
    public void importPokedex() {
        try {
            CSVReader reader = new CSVReader(
                    new InputStreamReader(new ClassPathResource(
                            "pokedex/pokedex.csv")
                            .getInputStream()));
            List<String[]> records = reader.readAll();
            records.remove(0); // Remove header row

            for (String[] record : records) {

                Optional<Pokemon> existingPokemon = pokemonRepository.findById(Integer.parseInt(record[0]));

                if (!existingPokemon.isPresent()) {
                    Pokemon pokemon = new Pokemon();
                    pokemon.setCanonicalId(Integer.parseInt(record[0]));
                    pokemon.setCanonicalName(record[1]);
                    pokemon.setType1(Type.valueOf(record[2].toUpperCase()));
                    pokemon.setType2(!record[3].isEmpty() ? Type.valueOf(record[3].toUpperCase()) : null);
                    pokemon.setGeneration(Integer.parseInt(record[11]));
                    pokemonRepository.save(pokemon);
                }
            }

            reader.close();
            System.out.println("Pokedex data imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
