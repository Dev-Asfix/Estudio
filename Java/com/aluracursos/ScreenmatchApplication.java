package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=ef162820");
		//var json = consumoAPI.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);

		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);

		json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=ef162820");
		DatosEpisodio datosEpisodio = conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println(datosEpisodio);

		List<DatosTemporada> datosTemporadas = new ArrayList<>();

		for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
			json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=ef162820");
			var temporadas = conversor.obtenerDatos(json , DatosTemporada.class);
			datosTemporadas.add(temporadas);
		}

		datosTemporadas.forEach(System.out::println);
	}
}
