package com.example.swim_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "message_conversion_log")
@Getter 
@Setter
public class MessageConversionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference_id")
    private Long referenceId;

    private String date; // Varchar(8) - Index: DATE
    private String type;
    private String category;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "ipm_id")
    private String ipmId;

    private String origin;

    @Column(name = "filing_time")
    private String filingTime;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "converted_time")
    private LocalDateTime convertedTime;

    private String status;
    private String remark;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "reference_id", insertable = false, updatable = false)
    // private MessageConversionLog referenceMessage;
}
