package com.example.swim_server.controller;

import com.example.swim_server.entity.SystemLog;
import com.example.swim_server.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/system-logs")
public class SystemLogController {

    @Autowired
    private SystemLogService service;

    @GetMapping
    public List<SystemLog> getAll() {
        return service.getAllLogs();
    }

    @PostMapping
    public ResponseEntity<SystemLog> createLog(@RequestBody SystemLog log) {
        return ResponseEntity.ok(service.saveLog(log));
    }

    @GetMapping("/module/{module}")
    public List<SystemLog> getByModule(@PathVariable String module) {
        return service.getLogsByModule(module);
    }
}