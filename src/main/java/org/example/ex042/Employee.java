/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex042;

public class Employee {
    private String f_Name;
    private String l_Name;
    private int salary;
    //takes string, parses the three values from the string, and assigns these to Class variables
    public Employee(String data){
        String information[]=parseString(data);
        this.f_Name=information[0];
        this.l_Name=information[1];
        this.salary=Integer.parseInt(information[2]);
    }
    //Takes a String then puts the three components of the string (as divided by ',' and
    //adds each of the elements to an array of string with 3 indexes, then returns this array
    public static String[] parseString(String data){
        String retString[]={"","",""};
        int index=0;
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)==','){
                index++;
            }else{
                retString[index]+=data.charAt(i);
            }
        }
        return retString;
    }

    //Getters for the three class variables
    public String getF_Name() {
        return f_Name;
    }
    public String getL_Name() {
        return l_Name;
    }
    public int getSalary() {
        return salary;
    }
}
