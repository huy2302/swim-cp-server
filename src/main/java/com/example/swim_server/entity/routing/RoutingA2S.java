package com.example.swim_server.entity.routing;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

// RoutingA2S.java (AMHS to SWIM)
@Entity
@Table(name = "routing_a2s")
@Data
public class RoutingA2S {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer priority;
    private Boolean enabled = true;

    @Column(name = "amhs_originator")
    private String amhsOriginator; // Có thể để trống hoặc dùng "*"

    @Column(name = "amhs_destination", nullable = false)
    private String amhsDestination;

    @Column(name = "amhs_msg_type")
    private String amhsMsgType;

    @Column(name = "swim_domain")
    private String swimDomain; // FIXM, AIXM, IWXXM

    @Column(name = "swim_topic")
    private String swimTopic;

     @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String description;
}
