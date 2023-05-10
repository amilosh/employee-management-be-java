package com.amilosh.service.impl;

import com.amilosh.entity.Task;
import com.amilosh.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public Task createWithName(String name) {
        return Task.builder()
                .name(name)
                .build();
    }
}
