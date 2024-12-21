package med.voll.api.domain.consulta.validaciones.cancelamiento;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.MotivoCancelamiento;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMotivoCancelamiento implements ValidadorCancelamientoDeConsulta {
    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var motivo = datos.motivo();

        // Validamos si el motivo es null
        if (motivo == null) {
            throw new ValidacionException("¡El motivo de cancelación es obligatorio!");
        }

        // Verificamos si el motivo es uno de los valores válidos
        if (motivo != MotivoCancelamiento.PACIENTE_DESISTIO &&
                motivo != MotivoCancelamiento.MEDICO_CANCELO &&
                motivo != MotivoCancelamiento.OTROS) {
            throw new ValidacionException("¡El motivo de cancelación no es válido!");
        }
    }
}