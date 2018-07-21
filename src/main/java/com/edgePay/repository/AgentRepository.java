package com.edgePay.repository;

import com.edgePay.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    public Agent findByUsername(String username);
}
