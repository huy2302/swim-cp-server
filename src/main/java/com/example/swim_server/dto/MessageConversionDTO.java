package com.example.swim_server.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MessageConversionDTO {
    private Long id;
    private String messageId;
    private String type;
    private String origin;
    private String status;
    private LocalDateTime convertedTime;
    private String remark;
}
