package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosReservaConsulta(
        Long id,

        @NotNull
        Long idPaciente,

        Long idMedico,
        @Future
        @NotNull
        LocalDateTime fecha,

        Especialidad especialidad
) {
}
