package com.edgePay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationTypeRepository, Long>
{

}
