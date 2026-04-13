package com.example.swim_server.repository;

import com.example.swim_server.entity.MessageArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<MessageArchive, UUID> {

    // Tìm theo các định danh AMHS
    Optional<MessageArchive> findByMsgId(String msgId);
    Optional<MessageArchive> findByMtsId(String mtsId);
    Optional<MessageArchive> findByIpmId(String ipmId);

    // Lấy bản tin theo hướng (Direction)
    List<MessageArchive> findByDirectionOrderByTimestampDesc(String direction);

    // Lấy bản tin theo trạng thái xử lý
    List<MessageArchive> findByProcessingStatus(String status);

    // Lấy tất cả và sắp xếp theo thời gian giảm dần
    List<MessageArchive> findAllByOrderByTimestampDesc();
}
