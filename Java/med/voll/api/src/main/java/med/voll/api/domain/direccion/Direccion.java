package med.voll.api.domain.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    private String calle;
    private String distrito;
    private String ciudad;
    private String numero;
    private String complemento;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Direccion(DatosDireccion datosDireccion){
        this.calle = datosDireccion.calle();
        this.distrito = datosDireccion.distrito();
        this.ciudad = datosDireccion.ciudad();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
    }

    public Direccion actualizarDatos(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.distrito = datosDireccion.distrito();
        this.ciudad = datosDireccion.ciudad();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
        return this;
    }

}
