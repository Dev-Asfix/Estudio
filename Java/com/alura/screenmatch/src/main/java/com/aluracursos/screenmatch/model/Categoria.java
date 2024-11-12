package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action","Acción"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comedia"),
    DRAMA("Drama", "Drama"),
    CRIMEN("Crimen", "Crimen"),
    AVENTURA("Adventure", "Aventura");

    private String categoriaOmdb;
    private String categoriaEpanol;

        Categoria (String categoriaOmdb , String categoriaEpanol){
            this.categoriaEpanol = categoriaEpanol;
            this.categoriaOmdb = categoriaOmdb;
        }

    public static Categoria fromString(String text){
            for(Categoria categoria : Categoria.values()){
                if(categoria.categoriaOmdb.equalsIgnoreCase(text)){
                    return categoria;
                }

            }
        throw new IllegalArgumentException("Ninguna categoria encontrada : " + text);
    }

    public static Categoria fromEspanol(String text){
            for(Categoria categoria : Categoria.values()){
                if(categoria.categoriaEpanol.equalsIgnoreCase(text)){
                    return categoria;
                }
            }
            throw new IllegalArgumentException("Ninguna categoria encontrada : " + text);
    }
}
