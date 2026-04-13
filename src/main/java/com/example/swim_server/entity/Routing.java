package com.example.swim_server.entity;

import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@Table(name = "routing")
@Data
public class Routing {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(length = 50)
    private String direction; // Ví dụ: AFTN_TO_AMQP, AMQP_TO_AFTN

    @Column(name = "message_type", length = 20)
    private String messageType; // FPL, ARR, DEP, NOTAM...

    @Column(name = "amqp_account", length = 50)
    private String amqpAccount;

    @Column(name = "send_queue", length = 50)
    private String sendQueue;

    @Column(name = "receive_queue", length = 100)
    private String receiveQueue;

    @Column(name = "sender_aftn_address", length = 100)
    private String senderAftnAddress;

    @Column(name = "aftn_recipients", length = 100)
    private String aftnRecipients;
}
