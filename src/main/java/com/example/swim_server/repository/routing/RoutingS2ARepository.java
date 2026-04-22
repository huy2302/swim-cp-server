package com.example.swim_server.repository.routing;
import com.example.swim_server.entity.routing.RoutingS2A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

@Repository
public interface RoutingS2ARepository extends JpaRepository<RoutingS2A, UUID> {
    List<RoutingS2A> findAllByOrderByPriorityAsc();

    // @Query("SELECT r FROM RoutingS2A r ORDER BY r.updatedAt DESC")
    List<RoutingS2A> findAllByOrderByUpdatedAtDesc();
}
