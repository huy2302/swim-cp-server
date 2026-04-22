package com.example.swim_server.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class A2SRuleDto {
    private Integer priority;
    private Boolean enabled;

    private String amhsOriginator;
    private String amhsDestination;
    private String amhsMsgType;

    private String swimDomain;
    private String swimTopic;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String description;
}
