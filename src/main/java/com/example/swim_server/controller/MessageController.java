package com.example.swim_server.controller;

import com.example.swim_server.entity.MessageArchive;
import com.example.swim_server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/archive")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public MessageArchive create(@RequestBody MessageArchive message) {
        return service.archiveNewMessage(message);
    }

    // URL: GET http://localhost:8080/api/archive/all
    @GetMapping("/all")
    public List<MessageArchive> getAll() {
        return service.getAllMessages();
    }

    @GetMapping("/direction/{dir}")
    public List<MessageArchive> getByDir(@PathVariable String dir) {
        return service.getMessagesByDirection(dir.toUpperCase());
    }

    @PatchMapping("/{uuid}/status")
    public MessageArchive updateStatus(@PathVariable UUID uuid, @RequestParam String status) {
        return service.updateStatus(uuid, status);
    }

    @GetMapping("/search")
    public MessageArchive search(@RequestParam String id) {
        return service.findByAnyId(id);
    }
}
