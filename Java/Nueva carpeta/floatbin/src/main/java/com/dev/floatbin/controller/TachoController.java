package com.dev.floatbin.controller;

import com.dev.floatbin.config.WebSocketHandler;
import com.dev.floatbin.service.NeuralNetworkService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/tacho")
class TachoController {
    private final NeuralNetworkService neuralNetworkService;
    private final WebSocketHandler webSocketHandler;

    public TachoController(NeuralNetworkService neuralNetworkService, WebSocketHandler webSocketHandler) {
        this.neuralNetworkService = neuralNetworkService;
        this.webSocketHandler = webSocketHandler;
    }

    @GetMapping("/estado")
    public Map<String, Object> getEstadoRest(@RequestParam double distance) {
        String estado = neuralNetworkService.predictEstado(distance);
        System.out.println("📡 Estado calculado: " + estado + " para distancia " + distance);

        Map<String, Object> data = Map.of(
                "estado", estado,
                "distancia", distance,
                "timestamp", System.currentTimeMillis()
        );

        webSocketHandler.enviarMensajeAClientes(data);
        return data;
    }

}
