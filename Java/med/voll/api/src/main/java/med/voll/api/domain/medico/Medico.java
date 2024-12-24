package med.voll.api.domain.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;


@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    private boolean activo;

    public Medico(DatosRigistroMedico datos){
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
        this.telefono = datos.telefono();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void actualizrDatos(@Valid DatosActualizarMedico datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if(datos.documento() != null){
            this.documento = datos.documento();
        }
        if(datos.direccion() != null){
            this.direccion = direccion.actualizarDatos(datos.direccion());

        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
