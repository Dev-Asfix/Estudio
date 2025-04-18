package med.voll.api.domain.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable pageable);
    @Query(value = """
        select m.* 
        from medicos m
        where
        m.activo = true
        and m.especialidad = :especialidad
        and m.id not in (
            select c.medico_id 
            from consultas c 
            where c.fecha = :fecha
        and
            c.motivo_cancelamiento is null
        )
        order by rand()
        limit 1
        """, nativeQuery = true)

    Medico elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad especialidad, LocalDateTime fecha);


    @Query("""
            select m.activo
            from Medico m
            where
            m.id = :idMedico
            """)
    boolean findByActivoById(Long idMedico);
}
