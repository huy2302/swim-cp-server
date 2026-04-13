package com.example.swim_server.controller;

import com.example.swim_server.entity.Routing;
import com.example.swim_server.service.RoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/routing")
@CrossOrigin(origins = "*")
public class RoutingController {

    @Autowired
    private RoutingService service;

    @GetMapping
    public List<Routing> getAll() {
        return service.getAllRoutes();
    }

    @PostMapping
    public Routing create(@RequestBody Routing routing) {
        return service.saveRoute(routing);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        service.deleteRoute(uuid);
    }
}
