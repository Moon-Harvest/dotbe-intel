package com.aia.dotbe_intel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aia.dotbe_intel.service.import_services.MovesetImportService;
import com.aia.dotbe_intel.service.import_services.PokedexImportService;
import com.aia.dotbe_intel.service.import_services.TypingChartImportService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class DotbeIntelApplication implements CommandLineRunner {

	private final PokedexImportService pokedexImportService;
	private final MovesetImportService movesetImportService;
	private final TypingChartImportService typingChartImportService;

	public static void main(String[] args) {
		SpringApplication.run(DotbeIntelApplication.class, args);
	}

	@Override
	public void run(String... args) {
		pokedexImportService.importPokedex();
		movesetImportService.importMoves();
		typingChartImportService.importTypingChart();
	}

}
