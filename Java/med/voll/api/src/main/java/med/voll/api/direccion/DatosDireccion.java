package med.voll.api.direccion;

import med.voll.api.medico.Especialidad;

public record DatosDireccion(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento
        ) {


}
