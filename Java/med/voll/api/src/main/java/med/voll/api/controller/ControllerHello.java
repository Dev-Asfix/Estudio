package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("ruta")
public class ControllerHello {

    @GetMapping("/queso")
    public int helloworld(){
        return 54;
    }

    @GetMapping("/ejemplo")
    public List<Object> hola(){
        List<Object> hol = new ArrayList<>();

        hol.add("hola");
        hol.add("Gato");
        hol.add(23);
        hol.add(true);
        return hol;
    }

}
