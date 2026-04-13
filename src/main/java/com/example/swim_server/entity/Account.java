package com.example.swim_server.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "account_name", unique = true, length = 50)
    private String accountName;

    @Column(length = 20)
    private String protocol; // Ví dụ: AMHS, SWIM, SOLACE, FIXM_FLOW

    private String host;

    private Integer port;

    @Column(name = "config_json", columnDefinition = "TEXT")
    private String configJson; // Lưu cấu hình chi tiết dạng JSON string

    @Column(length = 20)
    private String status; // ACTIVE, INACTIVE

    @Column(name = "bind_status", length = 20)
    private String bindStatus; // CONNECTED, DISCONNECTED, BINDING
}