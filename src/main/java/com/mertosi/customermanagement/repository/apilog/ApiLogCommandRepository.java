package com.mertosi.customermanagement.repository.apilog;

import com.mertosi.customermanagement.model.entity.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiLogCommandRepository extends JpaRepository<ApiLog, Long> {
}
