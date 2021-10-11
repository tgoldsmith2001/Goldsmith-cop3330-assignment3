/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex043;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class App {
    public static void main(String args[]) throws IOException {
        String name, author, javaScript, CSS;
        Scanner input= new Scanner(System.in);
        name=readLine("Site Name: ",input);
        author =readLine("Author: ",input);
        javaScript=yesNoResponse("Do you want a folder for JavaScript (Y or N): ",input);
        CSS=yesNoResponse("Do you want a folder for CSS (Y or N): ",input);
        generateWebsite(name,author,javaScript,CSS);
    }
    //takes in a prompt as the parameter, prints this prompt, and returns input on next line
    static String readLine(String prompt, Scanner input){
        System.out.print(prompt);
        return (input.nextLine());
    }
    //Prints parameter prompt, and takes input until user enters 'y' or 'n', then returns this value
    static String yesNoResponse(String prompt, Scanner input){
        String response;
        while(true) {
            System.out.print(prompt);
            response = input.nextLine();
            response=response.toLowerCase(Locale.ROOT);
            if(response.equals("y")||response.equals("n"))
                break;
            else{
                System.out.println("Invalid input enter either y or n");
                continue;
            }
        }
        return response;
    }
    //Container method to call the various creation methods
    static void generateWebsite(String siteName,String author, String jc, String css) throws IOException {
        String basePath= "src/main/java/org/example/ex043";
        makeDirectory(basePath,siteName);
        makeHtmlFile(basePath+"/"+siteName,"index",siteName,author);
        if(jc.equals("y"))
            makeDirectory(basePath+"/"+siteName,"js");
        if(css.equals("y"))
            makeDirectory(basePath+"/"+siteName,"css");
    }
    //Generates a directory at a given path and name, returns true if the directory was created successfully
    static boolean makeDirectory(String path, String name){
        File file= new File(path+"/"+name);
        boolean B= file.mkdir();
        return B;
    }
    //Generates a html file, at a given path at name, then adds tags for name of site
    //and author of the site, then returns true if the file was generated correctly
    static boolean makeHtmlFile(String path, String name, String siteName, String author) throws IOException {
        boolean B =false;
        File file= new File(path+"/"+name+".html");
        System.out.format("File name is %s\n",path+"/"+name+".html");
        if (!file.exists()) {
            B=file.createNewFile();
        }
        FileWriter FW = new FileWriter(file);
        BufferedWriter BW = new BufferedWriter(FW);
        String title_tag= "<title>"+siteName+"</title>";
        BW.write(title_tag);
        String meta_tag= "\n<meta>"+author+"</meta>";
        BW.write(meta_tag);
        BW.close();
        return B;
    }
}
