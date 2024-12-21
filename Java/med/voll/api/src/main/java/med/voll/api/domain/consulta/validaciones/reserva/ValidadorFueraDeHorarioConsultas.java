package med.voll.api.domain.consulta.validaciones.reserva;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorFueraDeHorarioConsultas implements ValidadorDeConsultas{
    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var horarioAntesDeApertura = fechaConsulta.getHour()< 7;
        var horarioDespuesDeCierreClinica = fechaConsulta.getHour() > 18;
        if(domingo || horarioAntesDeApertura || horarioDespuesDeCierreClinica){
            throw new ValidacionException("Horario seleccionado fuera de horario de atendimiento de la clinica");
        }
    }
}
