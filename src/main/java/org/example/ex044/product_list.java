/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex044;

import java.util.ArrayList;

public class product_list {
    private ArrayList<product>products;
    public product_list(ArrayList<product>inventory){
        this.products=inventory;
    }

    //Getter function for the products variable
    public ArrayList<product> getProducts() {
        return products;
    }
}
