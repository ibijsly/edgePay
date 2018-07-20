package com.edgePay.repository;

import com.edgePay.model.RoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long> {
}
