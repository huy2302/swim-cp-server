package com.example.swim_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "gateway_log")
@Getter 
@Setter
public class GatewayLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khóa chính, tự tăng 

    @Column(name = "message_id")
    private String messageId; // Định danh message 

    private String direction; // AMHS_TO_SWIM hoặc SWIM_TO_AMHS 

    private String status; // NEW, PROCESSING, SENT, ERROR 

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage; // Thông tin lỗi nếu có 

    @Column(columnDefinition = "TEXT")
    private String payload; // Nội dung message 

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt; // Thời điểm ghi log 

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt; // Thời điểm cập nhật log 
}
