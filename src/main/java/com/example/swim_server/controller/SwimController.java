package com.example.swim_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/swim") // Tất cả các API sẽ bắt đầu bằng /api/swim
public class SwimController {

    // API kiểm tra trạng thái: GET http://localhost:8080/api/swim/status
    @GetMapping("/status")
    public String getStatus() {
        return "SWIM-AMHS Gateway is Running!";
    }

    // API mẫu lấy danh sách bản tin (Dummy data)
    @GetMapping("/messages")
    public List<Map<String, String>> getMessages() {
        return List.of(
                Map.of("id", "1", "type", "FIXM", "content", "Flight Plan VVTS-VVDN"),
                Map.of("id", "2", "type", "AIXM", "content", "NOTAM Update Runway 25L")
        );
    }
}
