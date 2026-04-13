package com.example.swim_server.controller;

import com.example.swim_server.entity.GatewayLog;
import com.example.swim_server.service.GatewayLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gateway-logs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GatewayLogController {

    private final GatewayLogService logService;

    @GetMapping
    public ResponseEntity<Page<GatewayLog>> getLogs(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        
        if (status != null) {
            return ResponseEntity.ok(logService.getLogsByStatus(status, pageable));
        }
        if (direction != null) {
            return ResponseEntity.ok(logService.getLogsByDirection(direction, pageable));
        }
        
        return ResponseEntity.ok(logService.getAllLogs(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GatewayLog> getLogDetail(@PathVariable Long id) {
        return ResponseEntity.ok(logService.getLogDetail(id));
    }
}
