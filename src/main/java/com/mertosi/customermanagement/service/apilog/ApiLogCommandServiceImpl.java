package com.mertosi.customermanagement.service.apilog;

import com.mertosi.customermanagement.model.entity.ApiLog;
import com.mertosi.customermanagement.repository.apilog.ApiLogCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiLogCommandServiceImpl implements ApiLogCommandService {
    private final ApiLogCommandRepository apiLogCommandRepository;


    @Override
    public ApiLog create(ApiLog apiLog) {
        return apiLogCommandRepository.save(apiLog);
    }
}
