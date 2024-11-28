package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.medico.Especialidad;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento
        ) {


}
