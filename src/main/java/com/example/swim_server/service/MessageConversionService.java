package com.example.swim_server.service;

import com.example.swim_server.dto.MessageConversionDTO;
import com.example.swim_server.entity.MessageConversionLog;
import com.example.swim_server.repository.MessageConversionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageConversionService {

    private final MessageConversionLogRepository repository;

    public Page<MessageConversionDTO> getConversionLogs(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public MessageConversionDTO getLogDetail(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bản ghi chuyển đổi với ID: " + id));
    }

    private MessageConversionDTO convertToDTO(MessageConversionLog entity) {
        MessageConversionDTO dto = new MessageConversionDTO();
        dto.setId(entity.getId());
        dto.setMessageId(entity.getMessageId());
        dto.setType(entity.getType());
        dto.setOrigin(entity.getOrigin());
        dto.setStatus(entity.getStatus());
        dto.setConvertedTime(entity.getConvertedTime());
        dto.setRemark(entity.getRemark());
        return dto;
    }
}
