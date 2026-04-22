package com.example.swim_server.dto;
import com.example.swim_server.dto.A2SRuleDto;
import com.example.swim_server.dto.S2ARuleDto;
import lombok.Data;
import java.util.List;

@Data
public class RoutingCreateRequest {
    private List<A2SRuleDto> a2sRules;
    private List<S2ARuleDto> s2aRules;
}
