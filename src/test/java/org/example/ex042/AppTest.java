package org.example.ex042;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    void sort() throws IOException {
        //Test 1 reads data from input files and tests sort function
        //Note this tests aspects of both sort and readFile functions
        ArrayList<Employee>toBeSorted= App.readFile("src/test/java/org/example/ex042/ex042_test.txt");
        toBeSorted=App.sort(toBeSorted);
        ArrayList<Employee>Sorted=App.readFile("src/test/java/org/example/ex042/ex042_test_sorted.txt");
        for (int i = 0; i < toBeSorted.size(); i++) {
            assertEquals(toBeSorted.get(i).getF_Name(),Sorted.get(i).getF_Name());
            assertEquals(toBeSorted.get(i).getL_Name(),Sorted.get(i).getL_Name());
            assertEquals(toBeSorted.get(i).getSalary(),Sorted.get(i).getSalary());
        }
    }
}