package com.example.swim_server.controller.routing;
import com.example.swim_server.dto.RoutingCreateRequest;
import com.example.swim_server.entity.routing.RoutingA2S;
import com.example.swim_server.entity.routing.RoutingS2A;
import com.example.swim_server.service.routing.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/routing")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Cho phép React gọi API
public class RoutingController {
    private final RoutingService routingService;

    // AMHS -> SWIM Endpoints
    @GetMapping("/a2s")
    public ResponseEntity<List<RoutingA2S>> getA2SRules() {
        return ResponseEntity.ok(routingService.getAllA2S());
    }

    @PostMapping
    public ResponseEntity<?> createRouting(
            @RequestBody RoutingCreateRequest request) {

        routingService.saveAllRouting(request);

        return ResponseEntity.ok(
                Map.of(
                        "status", "success",
                        "message", "All routing configurations saved"
                )
        );
    }

    @PostMapping("/a2s")
    public ResponseEntity<RoutingA2S> createA2SRule(@RequestBody RoutingA2S rule) {
        return ResponseEntity.ok(routingService.saveOrUpdateA2S(rule));
    }

    @DeleteMapping("/a2s/{id}")
    public ResponseEntity<Void> deleteA2SRule(@PathVariable UUID id) {
        routingService.deleteA2S(id);
        return ResponseEntity.noContent().build();
    }

    // SWIM -> AMHS Endpoints
    @GetMapping("/s2a")
    public ResponseEntity<List<RoutingS2A>> getS2ARules() {
        return ResponseEntity.ok(routingService.getAllS2A());
    }

    @PostMapping("/s2a")
    public ResponseEntity<RoutingS2A> createS2ARule(@RequestBody RoutingS2A rule) {
        return ResponseEntity.ok(routingService.saveOrUpdateS2A(rule));
    }

    @DeleteMapping("/s2a/{id}")
    public ResponseEntity<Void> deleteS2ARule(@PathVariable UUID id) {
        routingService.deleteS2A(id);
        return ResponseEntity.noContent().build();
    }
}
