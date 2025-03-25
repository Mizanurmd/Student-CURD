package com.mit.curd.configuration;

import com.mit.curd.dtoMapper.EmployeeMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public EmployeeMapper modelMapper() {
        return new EmployeeMapper();
    }
}
