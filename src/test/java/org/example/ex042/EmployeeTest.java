package org.example.ex042;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee A= new Employee("A,B,10");

    @Test
    void parseString() {
        String check1[]={"A","B","10"} ;
        assertArrayEquals(check1,Employee.parseString("A,B,10"));
    }

    @Test
    void getF_Name() {
        assertEquals(A.getF_Name(),"A");
    }

    @Test
    void getL_Name() {
        assertEquals(A.getL_Name(),"B");
    }

    @Test
    void getSalary() {
        assertEquals(Integer.toString(A.getSalary()),"10");
    }
}