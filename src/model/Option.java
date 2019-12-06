package model;

import java.io.Serializable;

public class Option implements Serializable {
    private String name;
    private float price;

    //constructors
    protected Option() {
        this("", 0);
    }

    protected Option(String name) {
        this(name, 0);
    }

    protected Option(float price) {
        this("", price);
    }

    protected Option(String name, float price) {
        this.name = name;
        this.price = price;
    }

    //getters
    protected String getName() {
        return this.name;
    }

    protected float getPrice() {
        return this.price;
    }

    //setters
    protected void setName(String name) {
        this.name = name;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    protected void print() {
        System.out.printf("- %s: $%.2f\n", name, price);
    }
}
