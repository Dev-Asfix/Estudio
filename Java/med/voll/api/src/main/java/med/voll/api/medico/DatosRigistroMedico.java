package med.voll.api.medico;

import med.voll.api.direccion.DatosDireccion;

public record DatosRigistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion
        ) {
}
