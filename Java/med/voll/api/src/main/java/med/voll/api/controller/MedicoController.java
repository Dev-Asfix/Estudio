package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.Value;
import med.voll.api.medico.DatosRigistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    //Ojo que no es recomendable para testing , porque a lo declaramos a nivel de repository , y es mejor con setter

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void registrar(@RequestBody @Valid DatosRigistroMedico datos){

        System.out.println("datos recibidos " + datos);
        repository.save(new Medico(datos));
    }
}
