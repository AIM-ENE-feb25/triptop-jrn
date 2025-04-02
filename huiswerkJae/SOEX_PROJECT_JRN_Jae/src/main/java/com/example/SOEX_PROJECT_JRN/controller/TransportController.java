package com.example.SOEX_PROJECT_JRN.controller;

import com.example.SOEX_PROJECT_JRN.model.TransportRequest;
import com.example.SOEX_PROJECT_JRN.model.TransportResponse;
import com.example.SOEX_PROJECT_JRN.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private final TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping("/getOptions")
    public TransportResponse getTransportOptions(@RequestBody TransportRequest request) {
        return transportService.getTransportData(request);
    }
}
