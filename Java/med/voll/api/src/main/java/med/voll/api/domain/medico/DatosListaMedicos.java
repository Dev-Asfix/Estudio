package med.voll.api.domain.medico;


public record DatosListaMedicos(
        Long id,
        String nombre,
        String especialidad,
        String documento,
        String email
        //String telefono
) {
    public DatosListaMedicos(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());
    }
}
