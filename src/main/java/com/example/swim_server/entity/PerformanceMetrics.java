package com.example.swim_server.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "performance_metrics")
@Data
public class PerformanceMetrics {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    private LocalDateTime timestamp;

    @Column(name = "cpu_usage")
    private Double cpuUsage;

    @Column(name = "heap_memory")
    private Double heapMemory;

    @Column(name = "msg_in_count")
    private Integer msgInCount;

    @Column(name = "msg_out_count")
    private Integer msgOutCount;

    @Column(name = "active_threads")
    private Integer activeThreads;

    @PrePersist
    protected void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
    }
}