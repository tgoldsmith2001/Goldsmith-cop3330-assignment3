/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex046;

public class Word {
    private String word;
    private int numOccurences;
    public Word(String word, int numOccurences){
        this.word=word;
        this.numOccurences=numOccurences;
    }

    //Getter and Setter functions for the variables
    public void setNumOccurences(int numOccurences) {
        this.numOccurences = numOccurences;
    }
    public int getNumOccurences() {
        return numOccurences;
    }
    public String getWord() {
        return word;
    }
}
