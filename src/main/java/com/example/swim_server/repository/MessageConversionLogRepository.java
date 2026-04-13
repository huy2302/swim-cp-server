package com.example.swim_server.repository;

import com.example.swim_server.entity.MessageConversionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MessageConversionLogRepository extends JpaRepository<MessageConversionLog, Long> {
    
    // Tìm kiếm theo Index DATE đã có sẵn trong DB 
    List<MessageConversionLog> findByDate(String date);
    
    // Tìm kiếm theo Index MESSAGE_ID 
    Optional<MessageConversionLog> findByMessageId(String messageId);
    
    // Tìm kiếm theo tổ hợp Index ORIGIN (filing_time + origin) 
    List<MessageConversionLog> findByOriginAndFilingTime(String origin, String filingTime);

    // Phân trang cho giao diện Control Position
    Page<MessageConversionLog> findAll(Pageable pageable);
}
