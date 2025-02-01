package com.aia.dotbe_intel.service.import_services;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.aia.dotbe_intel.model.TypeEffectiveness;
import com.aia.dotbe_intel.repository.TypeEffectivenessRepository;
import com.opencsv.CSVReader;

import jakarta.transaction.Transactional;

@Service
public class TypingChartImportService {

    private final TypeEffectivenessRepository typeEffectivenessRepository;

    public TypingChartImportService(TypeEffectivenessRepository typeEffectivenessRepository) {
        this.typeEffectivenessRepository = typeEffectivenessRepository;
    }

    @Transactional
    public void importTypingChart() {
        try {
            CSVReader reader = new CSVReader(
                    new InputStreamReader(new ClassPathResource(
                            "typing_chart/typing_chart.csv")
                            .getInputStream()));
            List<String[]> records = reader.readAll();
            records.remove(0); // Remove header row

            for (String[] record : records) {

                Optional<TypeEffectiveness> existingPokemon = typeEffectivenessRepository.findByName(record[0]);

                if (!existingPokemon.isPresent()) {
                    TypeEffectiveness typeEffectiveness = new TypeEffectiveness();
                    typeEffectiveness.setName(record[0]);
                    typeEffectiveness.setNormal(Double.parseDouble(record[1]));
                    typeEffectiveness.setFire(Double.parseDouble(record[2]));
                    typeEffectiveness.setWater(Double.parseDouble(record[3]));
                    typeEffectiveness.setElectric(Double.parseDouble(record[4]));
                    typeEffectiveness.setGrass(Double.parseDouble(record[5]));
                    typeEffectiveness.setIce(Double.parseDouble(record[6]));
                    typeEffectiveness.setFighting(Double.parseDouble(record[7]));
                    typeEffectiveness.setPoison(Double.parseDouble(record[8]));
                    typeEffectiveness.setGround(Double.parseDouble(record[9]));
                    typeEffectiveness.setFlying(Double.parseDouble(record[10]));
                    typeEffectiveness.setPsychic(Double.parseDouble(record[11]));
                    typeEffectiveness.setBug(Double.parseDouble(record[12]));
                    typeEffectiveness.setRock(Double.parseDouble(record[13]));
                    typeEffectiveness.setGhost(Double.parseDouble(record[14]));
                    typeEffectiveness.setDragon(Double.parseDouble(record[15]));
                    typeEffectiveness.setDark(Double.parseDouble(record[16]));
                    typeEffectiveness.setSteel(Double.parseDouble(record[17]));
                    typeEffectiveness.setFairy(Double.parseDouble(record[18]));
                    typeEffectivenessRepository.save(typeEffectiveness);
                }
            }

            reader.close();
            System.out.println("TypingChart data imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
