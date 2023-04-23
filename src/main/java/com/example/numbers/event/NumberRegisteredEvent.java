package com.example.numbers.event;

import com.example.numbers.domain.NumberDto;
import org.springframework.context.ApplicationEvent;

public class NumberRegisteredEvent extends ApplicationEvent {
    private NumberDto numberDto;

    public NumberRegisteredEvent(Object source) {
        super(source);
    }

    public NumberRegisteredEvent(Object source, NumberDto numberDto) {
        super(source);
        this.numberDto = numberDto;
    }

    public int addNumbers() {
        return numberDto.getNumberX() + numberDto.getNumberY();
    }
    public int subtractNumbers() {
        return numberDto.getNumberX() + numberDto.getNumberY();
    }

    public int multiplyNumbers() {
        return numberDto.getNumberX() * numberDto.getNumberY();
    }
    public int divideNumbers() {

        return numberDto.getNumberX() / numberDto.getNumberY();
    }
}
