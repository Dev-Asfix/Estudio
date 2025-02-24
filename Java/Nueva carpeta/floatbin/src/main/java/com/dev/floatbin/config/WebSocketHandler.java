package com.dev.floatbin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println("Nueva conexión WebSocket establecida: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("Mensaje recibido: " + message.getPayload());

        // Convertir el mensaje recibido en JSON
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> receivedData = objectMapper.readValue(message.getPayload(), Map.class);

        // Enviar los datos a todos los clientes conectados
        for (WebSocketSession webSocketSession : sessions) {
            if (webSocketSession.isOpen()) {
                webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(receivedData)));
            }
        }
    }




    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println("Conexión cerrada: " + session.getId());
    }

    public void enviarMensajeAClientes(Map<String, Object> datos) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(datos);
            for (WebSocketSession session : sessions) {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(jsonMessage));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
