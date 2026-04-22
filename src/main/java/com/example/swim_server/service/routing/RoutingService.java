package com.example.swim_server.service.routing;
import com.example.swim_server.dto.RoutingCreateRequest;
import com.example.swim_server.entity.routing.RoutingA2S;
import com.example.swim_server.entity.routing.RoutingS2A;
import com.example.swim_server.repository.routing.RoutingA2SRepository;
import com.example.swim_server.repository.routing.RoutingS2ARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoutingService {
    private final RoutingA2SRepository a2sRepository;
    private final RoutingS2ARepository s2aRepository;

    // --- Logic cho AMHS to SWIM ---
    public List<RoutingA2S> getAllA2S() {
        return a2sRepository.findAllByOrderByUpdatedAtDesc();
    }

    @Transactional
    public void saveAllRouting(RoutingCreateRequest request) {

        // 2️⃣ Save A2S (AMHS → SWIM)
        List<RoutingA2S> a2sList = request.getA2sRules()
                .stream()
                .map(dto -> {
                    RoutingA2S entity = new RoutingA2S();
                    entity.setPriority(dto.getPriority());
                    entity.setEnabled(dto.getEnabled());
                    entity.setAmhsOriginator(dto.getAmhsOriginator());
                    entity.setAmhsDestination(dto.getAmhsDestination());
                    entity.setAmhsMsgType(dto.getAmhsMsgType());
                    entity.setSwimDomain(dto.getSwimDomain());
                    entity.setSwimTopic(dto.getSwimTopic());
                    entity.setCreatedAt(dto.getCreatedAt());
                    entity.setUpdatedAt(dto.getUpdatedAt());
                    entity.setDescription(dto.getDescription());
                    return entity;
                })
                .toList();


        // 3️⃣ Save S2A (SWIM → AMHS)
        List<RoutingS2A> s2aList = request.getS2aRules()
                .stream()
                .map(dto -> {
                    RoutingS2A entity = new RoutingS2A();
                    entity.setPriority(dto.getPriority());
                    entity.setEnabled(dto.getEnabled());
                    entity.setSwimDomain(dto.getSwimDomain());
                    entity.setSwimMessageType(dto.getSwimMessageType());
                    entity.setSwimTopic(dto.getSwimTopic());
                    entity.setAmhsOriginator(dto.getAmhsOriginator());
                    entity.setAmhsDestination(dto.getAmhsDestination());
                    entity.setAmhsPriorityIndicator(dto.getAmhsPriorityIndicator());
                    entity.setCreatedAt(dto.getCreatedAt());
                    entity.setUpdatedAt(dto.getUpdatedAt());
                    entity.setAmhsFilingTimeMode(dto.getAmhsFilingTimeMode());
                    entity.setDescription(dto.getDescription());
                    return entity;
                })
                .toList();

        // Xoá toàn bộ cấu hình cũ
        a2sRepository.deleteAllInBatch();
        s2aRepository.deleteAllInBatch();

        // Thêm toàn bộ cấu hình mới
        s2aRepository.saveAll(s2aList);
        a2sRepository.saveAll(a2sList);
    }

    public RoutingA2S saveOrUpdateA2S(RoutingA2S rule) {
        return a2sRepository.save(rule);
    }

    public void deleteA2S(UUID id) {
        a2sRepository.deleteById(id);
    }

    // --- Logic cho SWIM to AMHS ---
    public List<RoutingS2A> getAllS2A() {
        return s2aRepository.findAllByOrderByUpdatedAtDesc();
    }

    public RoutingS2A saveOrUpdateS2A(RoutingS2A rule) {
        return s2aRepository.save(rule);
    }

    public void deleteS2A(UUID id) {
        s2aRepository.deleteById(id);
    }
}
