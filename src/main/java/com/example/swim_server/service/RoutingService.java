package com.example.swim_server.service;

import com.example.swim_server.entity.Routing;
import com.example.swim_server.repository.RoutingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RoutingService {

    @Autowired
    private RoutingRepository repository;

    public List<Routing> getAllRoutes() {
        return repository.findAll();
    }

    public Routing saveRoute(Routing routing) {
        return repository.save(routing);
    }

    public void deleteRoute(UUID uuid) {
        repository.deleteById(uuid);
    }

    public List<Routing> getRoutesByDirection(String direction) {
        return repository.findByDirection(direction);
    }
}
