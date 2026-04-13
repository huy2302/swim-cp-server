package com.example.swim_server.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "message_archive")
@Data
public class MessageArchive {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "msg_id", length = 100)
    private String msgId;
    
    @Column(name = "mts_id", length = 100)
    private String mtsId;
    
    @Column(name = "aftn_address", length = 100)
    private String aftnAddress;

    @Column(name = "ipm_id", length = 100)
    private String ipmId;

    @Column(columnDefinition = "TEXT")
    private String recipients;

    @Column(length = 2)
    private String priority;

    @Column(length = 20)
    private String direction; // INBOUND/OUTBOUND

    private LocalDateTime timestamp;

    @Column(name = "raw_content", columnDefinition = "TEXT")
    private String rawContent;

    @Column(name = "processing_status", length = 20)
    private String processingStatus; // PENDING, PROCESSED, ERROR

    @PrePersist
    protected void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
    }
}
