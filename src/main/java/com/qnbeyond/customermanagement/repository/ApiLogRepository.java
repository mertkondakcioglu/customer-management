package com.qnbeyond.customermanagement.repository;

import com.qnbeyond.customermanagement.model.entity.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {
}
