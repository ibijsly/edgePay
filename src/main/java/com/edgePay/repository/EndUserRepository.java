package com.edgePay.repository;

import com.edgePay.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {
}
