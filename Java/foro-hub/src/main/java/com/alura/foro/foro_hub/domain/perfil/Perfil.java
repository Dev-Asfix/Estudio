package com.alura.foro.foro_hub.domain.perfil;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "perfil")
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nombre;

    public Perfil(@Valid DatosRegistroPerfil datos) {
        this.nombre = datos.nombre();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}