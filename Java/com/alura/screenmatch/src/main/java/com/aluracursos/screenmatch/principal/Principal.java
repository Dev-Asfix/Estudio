package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.*;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ef162820";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosSerie> datosSeries = new ArrayList<>();
    private List<Serie> series;
    private Optional<Serie> serieBuscada;

    private SerieRepository repositorio;

    public Principal(SerieRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                    4 - Buscar series por título
                    5 - Top 5 Series
                    6 - Buscar Series por Categoria
                    7 - Filtrar por series
                    8 - Buscar Episodio por Título
                    9 - Top 5 episodios por Serie
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarSeriePorCategoria();
                    break;
                case 7:
                    buscarSeriesPorTemporada();
                    break;
                case 8:
                    buscarEpisodioPorTitulo();
                    break;
                case 9 :
                    buscarTop5Episodios();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }


    private DatosSerie getDatosSerie() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        return datos;
    }
    private void buscarEpisodioPorSerie() {

        mostrarSeriesBuscadas();
        System.out.println("Escribe el nombre de la serie para ver episodios: ");
        var nombreSerie = teclado.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();
        if(serie.isPresent()){
            var serieEncontrada = serie.get();
            List<DatosTemporadas> temporadas = new ArrayList<>();

            for (int i = 1; i <=serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoApi.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d-> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);

        }



    }
    private void buscarSerieWeb() {
        DatosSerie datos = getDatosSerie();
        Serie serie = new Serie(datos);
        repositorio.save(serie);
        //datosSeries.add(datos);
        System.out.println(datos);
    }
    private void mostrarSeriesBuscadas() {
        series = repositorio.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo(){
        System.out.println("Escribe el nombre de la serie que quieres buscar");
        var nombreSerie = teclado.nextLine();
        serieBuscada = repositorio.findByTituloContainingIgnoreCase(nombreSerie);
        if(serieBuscada.isPresent()){
            System.out.println("Datos de la serie : " + serieBuscada.get());
        } else {
            System.out.println("NO encontrada");
        }
    }

    private void buscarTop5Series(){
        List<Serie> nombreSeries = repositorio.findTop4ByOrderByEvaluacionDesc();
        nombreSeries.forEach(e-> System.out.println("Serie : " +e.getTitulo() +" Evaluacion : " + e.getEvaluacion()));
    }

    private void buscarSeriePorCategoria(){
        System.out.println("Que categoria quieres Buscar : ");
        var nombreCategoria = teclado.nextLine();
        Categoria categoria = Categoria.fromEspanol(nombreCategoria);
        List<Serie> seriePorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Series por categoria "+ nombreCategoria);
        seriePorCategoria.forEach(System.out::println);
    }

    //Buscar por temporadas

    private void buscarSeriesPorTemporada(){
        System.out.println("Filtrar series por cuántas temporadas? : ");
        var totalTemporadas = teclado.nextInt();
        teclado.nextLine();

        System.out.println("¿Con evaluacion apartir de que valor ?");
        var evaluacion = teclado.nextDouble();
        teclado.nextLine();

        List<Serie> filtroSeries = repositorio.seriePorTemporadaYEvaluacion(totalTemporadas, evaluacion);
        System.out.println("Series filtradas : ");
        filtroSeries.forEach(s-> System.out.println(s.getTitulo() + " - evaluacion " + s.getEvaluacion()));

    }
    //Filtro por episodio el titulo

    private void buscarEpisodioPorTitulo(){
        System.out.println("Escribe el nombre del titulo : ");
        var nombreTitulo = teclado.nextLine();
        List<Episodio> listaEpidosio = repositorio.tituloEpidosio(nombreTitulo);

        listaEpidosio.forEach(e ->
                System.out.printf("Serie : %s - Nombre : %s - Temporada : %s - Evaluacion : %s \n",
                        e.getSerie(), e.getTitulo(),e.getTemporada(), e.getEvaluacion()));
    }

    //Top 5 series buscadas
    private void buscarTop5Episodios(){
        buscarSeriePorTitulo();
        if(serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            List<Episodio> lista5Episodio = repositorio.top5Episodios(serie);
            lista5Episodio.forEach(e ->
                    System.out.printf("Serie : %s - Nombre : %s - Temporada : %s - Evaluacion : %s \n",
                            e.getSerie().getTitulo(), e.getTitulo(),e.getTemporada(), e.getEvaluacion()));

        }

    }


}