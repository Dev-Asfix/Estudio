package med.voll.api.domain.medico;

import jakarta.persistence.EntityManager;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.paciente.DatosRegistroPaciente;
import med.voll.api.domain.paciente.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;



    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Deberia devolver null cuando el medico buscado existe pero no esta disponible")
    void elegirMedicoAleatorioDisponibleEnLaFechaEscenario1() {

        var lunesSiguienteALas10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10,0);
        var medico = registrarMedico("Medico1", "medico@gmail.com", "12345", Especialidad.CARDIOLOGIA);
        var paciente = registrarPaciente("Paciente1", "paciente@gmail.com", "123789");

        registrarConsulta(medico, paciente, lunesSiguienteALas10);

        var medicoLibre = medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad.CARDIOLOGIA, lunesSiguienteALas10);
        assertThat(medicoLibre).isNull();
    }


    private void registrarConsulta(Medico medico, Paciente paciente, LocalDateTime fecha) {
        em.persist(new Consulta(null, medico, paciente, fecha, null));

    }
    private Medico registrarMedico(String nombre, String email, String documento, Especialidad especialidad) {
        var medico = new Medico(new DatosRigistroMedico(
                nombre, email, "6145489789", documento, especialidad, datosDireccion()
        ));
        em.persist(medico);

        return medico;
    }



    private Paciente registrarPaciente(String nombre, String email, String documetno){
        var paciente = new Paciente(datosPaciente(nombre, email, documetno));
        em.persist(paciente);
        return paciente;
    }

    private DatosRigistroMedico datosMedico(String nombre, String email, String documento, Especialidad especialidad) {
        return new DatosRigistroMedico(
                nombre,
                email,
                "6145489789",
                documento,
                especialidad,
                datosDireccion()

        );
    }

    private DatosRegistroPaciente datosPaciente(String nombre, String email, String documento) {
        return new DatosRegistroPaciente(
                nombre,
                email,
                "1234564",
                documento,
                datosDireccion()
        );
    }

    private DatosDireccion datosDireccion() {
        return new DatosDireccion(
                "calle x",
                "distrito y",
                "ciudad z",
                "123",
                "1"
        );
    }


}