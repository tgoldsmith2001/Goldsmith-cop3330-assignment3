/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex041;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String args[]) throws IOException {
        ArrayList<String> Values= readFile("src/main/java/org/example/ex041/exercise41_input.txt");
        Values= Sort(Values);
        createFile(Values,"src/main/java/org/example/ex041","exercise41_output.txt");
    }
    //Sorts the Strings in alphabetical order and returns the result
    static ArrayList<String> Sort(ArrayList<String>Values){
        Collections.sort(Values);
        return Values;
    }
    //Read each line of text from an input file, then return the results as stored in an ArrayList
    static ArrayList<String> readFile(String path) throws IOException {
        ArrayList<String>Values=new ArrayList<String>();
        BufferedReader reader=null;
        reader = new BufferedReader(new FileReader(path));
        System.out.println("File read Correctly");
        String line;
        while((line=reader.readLine())!=null){
            Values.add(line);
        }
        return Values;
    }
    //Creates a new file, writes Strings from array to it, and returns true if successful
    static boolean createFile(ArrayList<String> Values, String path, String name){
        BufferedWriter BW= null;
        FileWriter FW=null;
        File file=null;
        try {
            file = new File(path+"/"+name);
            if (!file.exists()) {
                file.createNewFile();
            }
            BW = new BufferedWriter(new FileWriter(file));
            String num_Names= "Total of "+Integer.toString(Values.size()) +" names\n--------------------\n";
            BW.write(num_Names);
            for(int i=0;i<Values.size();i++){
                BW.write(Values.get(i)+"\n");
            }
            BW.close();
            System.out.println("File written Correctly");
            return true;
        }catch(IOException IOE){
            System.out.println("Could not Create, or find file");
            IOE.printStackTrace();
            return false;
        }
    }
}
