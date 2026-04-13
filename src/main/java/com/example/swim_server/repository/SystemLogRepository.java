package com.example.swim_server.repository;

import com.example.swim_server.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.List;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, UUID> {
    // Tìm log theo module (phục vụ việc lọc log như bạn cần)
    List<SystemLog> findByModule(String module);
    
    // Tìm log theo level (INFO, ERROR,...)
    List<SystemLog> findByLevel(String level);
}