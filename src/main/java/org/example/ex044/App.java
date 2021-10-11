/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex044;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input= new Scanner(System.in);
        product_list inventory=readJson("src/main/java/org/example/ex044/exercise44_input.json");
        runSearch(inventory,input);
    }
    //Prompts for a product name, and continues to prompt until product is found
    static void runSearch(product_list inventory, Scanner input){
        String entry;
        while(true){
            entry=readString(input,"What is your product name? ");
            int index= isInArray(inventory,entry);
            if(index!=-1){
                product foundItem= inventory.getProducts().get(index);
                System.out.format("Name: %s\nPrice: %.2f\nQuantity: %d\n",
                        foundItem.getName(),foundItem.getPrice(),foundItem.getQuantity());
                return;
            }else{
                System.out.println("Sorry, that product was not found in our inventory");
                continue;
            }
        }
    }
    //Reads in Json file from the input path, and returns value stored as product_list object
    static product_list readJson(String path) throws FileNotFoundException {
        final Type data_type= new TypeToken<product_list>(){}.getType();
        Gson gson = new Gson();
        JsonReader reader= new JsonReader(new FileReader(path));
        product_list allProducts= gson.fromJson(reader,data_type);
        return allProducts;
    }
    //Prints input prompt, returns resultant input from the prompt
    static String readString(Scanner input, String prompt){
        System.out.print(prompt);
        return input.nextLine();
    }
    //Checks if an input string is in a product_list, if so returns index the item is at otherwise returns -1
    static int isInArray(product_list checkArray, String name){
        for (int i = 0; i < checkArray.getProducts().size(); i++)
        {
            if(checkArray.getProducts().get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
