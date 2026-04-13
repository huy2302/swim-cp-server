package com.example.swim_server.service;

import com.example.swim_server.entity.MessageArchive;
import com.example.swim_server.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public MessageArchive archiveNewMessage(MessageArchive message) {
        return repository.save(message);
    }

    public List<MessageArchive> getMessagesByDirection(String direction) {
        return repository.findByDirectionOrderByTimestampDesc(direction);
    }

    public MessageArchive updateStatus(UUID uuid, String status) {
        MessageArchive msg = repository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Message not found"));
        msg.setProcessingStatus(status);
        return repository.save(msg);
    }

    public MessageArchive findByAnyId(String id) {
        return repository.findByMsgId(id)
                .or(() -> repository.findByMtsId(id))
                .or(() -> repository.findByIpmId(id))
                .orElse(null);
    }

    // Lấy toàn bộ không phân trang
    public List<MessageArchive> getAllMessages() {
        return repository.findAllByOrderByTimestampDesc();
    }
}