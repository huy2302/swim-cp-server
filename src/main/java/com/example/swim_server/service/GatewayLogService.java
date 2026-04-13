package com.example.swim_server.service;

import com.example.swim_server.entity.GatewayLog;
import com.example.swim_server.repository.GatewayLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GatewayLogService {

    private final GatewayLogRepository repository;

    public Page<GatewayLog> getAllLogs(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<GatewayLog> getLogsByStatus(String status, Pageable pageable) {
        return repository.findByStatus(status, pageable);
    }

    public Page<GatewayLog> getLogsByDirection(String direction, Pageable pageable) {
        return repository.findByDirection(direction, pageable);
    }

    public GatewayLog getLogDetail(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gateway Log không tồn tại với ID: " + id));
    }
}
