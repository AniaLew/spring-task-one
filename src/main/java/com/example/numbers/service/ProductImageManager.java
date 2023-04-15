package com.example.numbers.service;

import com.example.numbers.event.NumberRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductImageManager implements ApplicationListener<NumberRegisteredEvent> {
    private static final Logger logger = LoggerFactory.getLogger(ProductImageManager.class);
    @Override
    public void onApplicationEvent(NumberRegisteredEvent event) {
        logger.info("Addition: " + event.addNumbers());
        logger.info("Subtraction: : " + event.subtractNumbers());
        logger.info("Multiplication: : " + event.multiplyNumbers());
        logger.info("Division: : " + event.divideNumbers());
    }
}
