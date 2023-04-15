package com.example.beanlifecycle.controller;

import com.example.beanlifecycle.domain.ProductDto;
import com.example.beanlifecycle.event.ProductRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
public class ProductController implements ApplicationEventPublisherAware {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ApplicationEventPublisher publisher;

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        System.out.println("Register product: " + productDto.getProductName());
        logger.info("Register product: " + productDto.getProductName());
        publisher.publishEvent(new ProductRegisteredEvent(
                this,
                productDto.getProductName(),
                productDto.getOtherData()
                ));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
