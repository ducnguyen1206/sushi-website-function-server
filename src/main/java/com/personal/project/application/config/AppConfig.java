package com.personal.project.application.config;

import com.personal.project.domain.service.BookingService;
import com.personal.project.domain.service.impl.BookingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookingService bookingService() {
        return new BookingServiceImpl();
    }
}
