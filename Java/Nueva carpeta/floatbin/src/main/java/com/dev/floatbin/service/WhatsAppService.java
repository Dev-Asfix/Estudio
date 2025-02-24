package com.dev.floatbin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

//@Service
//public class WhatsAppService {
//    private static final String WHATSAPP_API_URL = "https://api.whatsapp.com/send";
//
//    public void sendWhatsAppMessage(String phoneNumber, String message) {
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> request = Map.of(
//                "phone", phoneNumber,
//                "message", message
//        );
//        restTemplate.postForObject(WHATSAPP_API_URL, request, String.class);
//    }
//}