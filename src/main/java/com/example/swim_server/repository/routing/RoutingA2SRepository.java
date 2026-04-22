package com.example.swim_server.repository.routing;
import com.example.swim_server.entity.routing.RoutingA2S;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoutingA2SRepository extends JpaRepository<RoutingA2S, UUID> {
    List<RoutingA2S> findAllByOrderByPriorityAsc();

    List<RoutingA2S> findAllByOrderByUpdatedAtDesc();
}
