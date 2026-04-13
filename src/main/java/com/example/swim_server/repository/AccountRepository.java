package com.example.swim_server.repository;

import com.example.swim_server.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    // Tìm kiếm tài khoản theo tên (vì tên là duy nhất)
    Optional<Account> findByAccountName(String accountName);
}