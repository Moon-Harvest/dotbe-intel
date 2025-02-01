package com.aia.dotbe_intel.service.import_services;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.aia.dotbe_intel.model.Move;
import com.aia.dotbe_intel.model.MoveCategory;
import com.aia.dotbe_intel.model.Type;
import com.aia.dotbe_intel.repository.MoveRepository;
import com.opencsv.CSVReader;

import jakarta.transaction.Transactional;

@Service
public class MovesetImportService {

    private final MoveRepository moveRepository;

    public MovesetImportService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    @Transactional
    public void importMoves() {
        try {
            CSVReader reader = new CSVReader(
                    new InputStreamReader(new ClassPathResource(
                            "moveset/moveset.csv")
                            .getInputStream()));
            List<String[]> records = reader.readAll();
            records.remove(0); // Remove header row

            for (String[] record : records) {

                Optional<Move> existingMove = moveRepository.findById(Integer.parseInt(record[0]));

                if (!existingMove.isPresent()) {
                    Move move = new Move();
                    move.setCanonicalId(Integer.parseInt(record[0]));
                    move.setCanonicalName(record[1]);
                    move.setType(Type.valueOf(record[2].toUpperCase()));
                    move.setCategory(MoveCategory.valueOf(record[3].toUpperCase()));
                    move.setPp(Byte.parseByte(record[4]));
                    move.setPower(record[5]);
                    move.setGeneration(record[7]);
                    moveRepository.save(move);
                }
            }

            reader.close();
            System.out.println("Moveset data imported successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
