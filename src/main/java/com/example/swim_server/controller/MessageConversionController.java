package com.example.swim_server.controller;

import com.example.swim_server.dto.MessageConversionDTO;
import com.example.swim_server.service.MessageConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Tùy chỉnh theo domain của Frontend CP
public class MessageConversionController {

    private final MessageConversionService conversionService;

    /**
     * Lấy danh sách nhật ký chuyển đổi điện văn (phân trang)
     * Ví dụ: GET /api/conversions?page=0&size=20
     */
    @GetMapping
    public ResponseEntity<Page<MessageConversionDTO>> getAllLogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "convertedTime") String sortBy,
            @RequestParam(defaultValue = "desc") String direction) {
        
        Sort sort = direction.equalsIgnoreCase("desc") 
                    ? Sort.by(sortBy).descending() 
                    : Sort.by(sortBy).ascending();
                    
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(conversionService.getConversionLogs(pageable));
    }

    /**
     * Tra cứu chi tiết một điện văn chuyển đổi theo ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<MessageConversionDTO> getLogById(@PathVariable Long id) {
        // Bạn có thể bổ sung method findById vào Service nếu cần xem chi tiết
        return ResponseEntity.ok(conversionService.getLogDetail(id));
    }
}
