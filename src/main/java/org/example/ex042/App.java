/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Goldsmith
 */
package org.example.ex042;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class App {
    public static void main(String args[]) throws IOException {
        ArrayList<Employee>employees= readFile("src/main/java/org/example/ex042/exercise42_input.txt");
        ArrayList<Employee>sortedEmployees= sort(employees);
        printData(sortedEmployees);
    }
    //Takes in an ArrayList of employees then returns an altered list that is
    //sorted in descending order of the salaries of each employee
    static ArrayList<Employee> sort(ArrayList<Employee> in){
        int curr_Max=-1, index=-1;
        ArrayList<Employee>data=in;
        for (int i = 0; i < data.size(); i++) {
            index=-1;
            curr_Max=0;
            for (int j = i; j < data.size(); j++) {
                if (curr_Max < data.get(j).getSalary()){
                    curr_Max = data.get(j).getSalary();
                    index=j;
                }
            }
            Swap(data,i,index);
        }
        return data;
    }
    //Swaps two values of an ArrayList at two designated indexes
    static ArrayList<Employee>Swap(ArrayList<Employee>data, int ind1, int ind2){
        Collections.swap(data,ind1,ind2);
        return data;
    }
    static void printData(ArrayList<Employee> employees){
        System.out.format("%-10s%-10s%-10s\n--------------------------\n","First","Last","Salary");
        for(Employee E: employees){
            System.out.format("%-10s%-10s%-10d\n",E.getF_Name(),E.getL_Name(),E.getSalary());
        }
    }
    //Reads in the input of each line from a file, and creates an ArrayList of employees using the string
    static ArrayList<Employee> readFile(String path) throws IOException {
        ArrayList<Employee>employees=new ArrayList<Employee>();
        BufferedReader reader=null;
        reader = new BufferedReader(new FileReader(path));
        String line;
        while((line=reader.readLine())!=null){
            employees.add(new Employee(line));
        }
        return employees;
    }
}
