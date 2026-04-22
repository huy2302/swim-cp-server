package com.example.swim_server.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class S2ARuleDto {
    private Integer priority;
    private Boolean enabled;

    private String swimDomain;
    private String swimTopic;
    private String swimMessageType;

    private String amhsOriginator;
    private String amhsDestination;
    private String amhsFilingTimeMode;
    private String amhsPriorityIndicator;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String description;
}
