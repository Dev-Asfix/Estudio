package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosActualizarPaciente(
        Long id,
        String nombre,
        @Email String email,
        String telefono,
        String documentoIdentidad,
        @Valid DatosDireccion direccion
) {
}
