package med.voll.api.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroConsulta (
        @NotNull Long idMedico,
        @NotNull Long idPaciente,
        @NotNull @Future LocalDateTime fecha,
        String motivo
){
}
