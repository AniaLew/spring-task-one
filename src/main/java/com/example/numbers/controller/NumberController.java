package com.example.numbers.controller;

import com.example.numbers.domain.NumberDto;
import com.example.numbers.event.NumberRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/numbers")
public class NumberController implements ApplicationEventPublisherAware {
    private static final Logger logger = LoggerFactory.getLogger(NumberController.class);
    private ApplicationEventPublisher publisher;

    @PostMapping("/createNumbers")
    public void createNumbers(@RequestBody NumberDto numberDto) {
        logger.info("Register number X: " + numberDto.getNumberX());
        logger.info("Register number Y: " + numberDto.getNumberX());
        publisher.publishEvent(new NumberRegisteredEvent(this, numberDto));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
