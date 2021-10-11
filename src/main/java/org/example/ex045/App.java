/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex045;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner input= new Scanner(System.in);
        String name=readString(input,"Enter the name of the output file: ");
        ArrayList<String> in= readFile("src/main/java/org/example/ex045/exercise45_input.txt");
        ArrayList <String> out=updateString(in,"utilize","use");
        createFile(out,"src/main/java/org/example/ex045",name);
    }
    //Takes ina  string and returns the string that was altered according to the replace and replacement parameters
    static ArrayList<String> updateString(ArrayList<String> in, String replace, String replacement){
        ArrayList<String>out=new ArrayList<String>();
        for(String Str:in) {
            String toAdd= Str.replaceAll(replace, replacement);
            out.add(toAdd);
        }
        return out;
    }
    //Reads in each line of a file, adds it to an ArrayList of Strings and returns this ArrayList
    static ArrayList<String> readFile(String path) throws IOException {
        ArrayList<String>text_lines= new ArrayList<String>();
        BufferedReader reader=null;
        reader = new BufferedReader(new FileReader(path));
        String line;
        while((line=reader.readLine())!=null){
            text_lines.add(line);
        }
        return text_lines;
    }
    //Prints a prompt input and returns the next input String
    static String readString(Scanner input, String prompt){
        System.out.print(prompt);
        return input.nextLine();
    }
    //Creates a new file with the name and path as dictated by the parameters
    // then takes in an ArrayList of Strings, prints each of these on their own line in the file
    static boolean createFile(ArrayList <String> out,String path, String name){
        BufferedWriter BW= null;
        FileWriter FW=null;
        File file=null;
        try {
            file = new File(path+"/"+name+".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BW = new BufferedWriter(new FileWriter(file));
            for(String Str: out)
                BW.write(Str+"\n");
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
