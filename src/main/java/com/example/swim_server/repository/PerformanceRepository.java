package com.example.swim_server.repository;

import com.example.swim_server.entity.PerformanceMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface PerformanceRepository extends JpaRepository<PerformanceMetrics, UUID> {
    // Lấy 20 bản ghi mới nhất để vẽ biểu đồ Real-time
    List<PerformanceMetrics> findTop20ByOrderByTimestampDesc();
}