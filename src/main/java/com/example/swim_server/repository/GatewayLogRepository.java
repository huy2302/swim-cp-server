package com.example.swim_server.repository;

import com.example.swim_server.entity.GatewayLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayLogRepository extends JpaRepository<GatewayLog, Long> {
    
    // Tìm kiếm theo Message ID (Sử dụng Index idx_message_id) 
    Page<GatewayLog> findByMessageId(String messageId, Pageable pageable);
    
    // Lọc theo trạng thái (Sử dụng Index idx_status) 
    Page<GatewayLog> findByStatus(String status, Pageable pageable);
    
    // Lọc theo hướng xử lý (Sử dụng Index idx_direction) 
    Page<GatewayLog> findByDirection(String direction, Pageable pageable);
}
