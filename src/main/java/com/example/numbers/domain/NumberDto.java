package com.example.numbers.domain;

public class NumberDto {
    private int numberX;
    private int numberY;

    public NumberDto(int numberX, int numberY) {
        this.numberX = numberX;
        this.numberY = numberY;
    }

    public int getNumberX() {
        return numberX;
    }

    public int getNumberY() {
        return numberY;
    }

}
