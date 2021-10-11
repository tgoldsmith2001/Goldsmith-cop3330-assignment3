/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex046;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws IOException {
        String in=readFile("src/main/java/org/example/ex046/exercise46_input.txt");
        String[]in_split= splitString(in);
        ArrayList<Word>wordQuantities=countWords(in_split);
        ArrayList<Word>out=sort(wordQuantities);
        printFinal(out);
    }
    //Prints the final ArrayList and an amount of '*' dictated by the numOccurrences variable
    static void printFinal(ArrayList<Word>out){
        for(Word w:out) {
            String Str=w.getWord()+":";
            System.out.format("%-9s%-1s",Str,"");
            for (int i = 0; i < w.getNumOccurences(); i++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    //Reads in file as dictated by path, then stores the lines in a String
    static String readFile(String path) throws IOException {
        String in="";
        BufferedReader reader=null;
        reader = new BufferedReader(new FileReader(path));
        String line;
        while((line=reader.readLine())!=null){
            in+=line+" ";
        }
        return in;
    }
    //Splits string into String Array,a s dictated by spaces in the String
    static String[] splitString(String in){
        String split[]= in.split("\\s+");
        return split;
    }
    //Counts the number of occurrences of each word and alters the Word object to reflect the amount of
    //occurrences of that word in the file, then returns the updated ArrayList of Words
    static ArrayList<Word> countWords(String[]in) {
        ArrayList<Word> out = new ArrayList<Word>();
        int x;
        for (String Str : in) {
            x=checkforWord(out, Str);
            //Case where the word has not been placed into out yet
            if (x==-1)
                out.add(new Word(Str,1));
            //Case where word has been found at an index of x in out
            else
                out.get(x).setNumOccurences(out.get(x).getNumOccurences()+1);
        }
        return out;
    }
    //Sorts the Words in order of descending numOccurrences, then returns the updated ArrayList
    static ArrayList<Word> sort(ArrayList<Word>words) {
        for (int i = 0; i < words.size()-1; i++) {
            for (int j = i+1; j < words.size(); j++) {
                if (words.get(j).getNumOccurences() > words.get(i).getNumOccurences()) {
                    swap(words,i,j);
                }
            }
        }
        return words;
    }
    //Swaps two indexes in ArrayList of Words
    static void swap(ArrayList<Word>words,int ind1, int ind2){
        Collections.swap(words,ind1,ind2);
    }
    //Runs through each Word in ArrayList and searches for a String as dictated by a String parameter
    static int checkforWord(ArrayList<Word>checkAgainst, String check){
        for (int i = 0; i < checkAgainst.size(); i++) {
            if(check.equals(checkAgainst.get(i).getWord()))
                return i;
        }
        return -1;
    }
}
