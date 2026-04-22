package com.example.swim_server.entity.routing;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "routing_s2a")
@Data
public class RoutingS2A {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer priority;
    private Boolean enabled = true;

    // SWIM Input
    private String swimTopic;
    private String swimDomain;
    private String swimMessageType;

    // AMHS Output
    private String amhsOriginator;
    
    @Column(columnDefinition = "TEXT")
    private String amhsDestination; // Lưu dạng chuỗi cách nhau bởi dấu phẩy

    private String amhsPriorityIndicator; // SS, DD, FF, GG
    private String amhsFilingTimeMode; // AUTO, MANUAL

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String description;
}
