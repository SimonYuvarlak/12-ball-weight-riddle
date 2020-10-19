package com.company;

public class Ball {
    private int number;
    private int weight;
    private String kind;

    Ball (int number, int weight, String kind) {
        this.number = number;
        this.weight = weight;
        this.kind = kind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
