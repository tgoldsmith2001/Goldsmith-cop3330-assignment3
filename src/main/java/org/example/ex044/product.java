/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex044;

public class product {
    private String name;
    private double price;
    private int quantity;
    public product(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    //Getter functions for the class variables
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
