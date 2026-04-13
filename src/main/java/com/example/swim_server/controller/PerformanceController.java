package com.example.swim_server.controller;

import com.example.swim_server.entity.PerformanceMetrics;
import com.example.swim_server.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/metrics")
@CrossOrigin(origins = "*")
public class PerformanceController {

    @Autowired
    private PerformanceService service;

    @GetMapping("/latest")
    public List<PerformanceMetrics> getLatest() {
        return service.getLatestMetrics();
    }

    @PostMapping
    public PerformanceMetrics collect(@RequestBody PerformanceMetrics metrics) {
        return service.saveMetrics(metrics);
    }
}
