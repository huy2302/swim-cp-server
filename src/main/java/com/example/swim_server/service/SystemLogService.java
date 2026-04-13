package com.example.swim_server.service;

import com.example.swim_server.entity.SystemLog;
import com.example.swim_server.repository.SystemLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class SystemLogService {

    @Autowired
    private SystemLogRepository repository;

    public List<SystemLog> getAllLogs() {
        return repository.findAll();
    }

    public SystemLog saveLog(SystemLog log) {
        return repository.save(log);
    }

    public List<SystemLog> getLogsByModule(String module) {
        return repository.findByModule(module);
    }

    public void deleteLog(UUID uuid) {
        repository.deleteById(uuid);
    }
}
