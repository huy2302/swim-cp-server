package com.example.swim_server.service;

import com.example.swim_server.entity.PerformanceMetrics;
import com.example.swim_server.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository repository;

    public List<PerformanceMetrics> getLatestMetrics() {
        return repository.findTop20ByOrderByTimestampDesc();
    }

    public PerformanceMetrics saveMetrics(PerformanceMetrics metrics) {
        return repository.save(metrics);
    }
}
