package org.example.ex044;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void isInArray() throws FileNotFoundException {
        product_list test1= App.readJson("src/test/java/org/example/ex044/ex044_test.json");
        assertEquals(0,App.isInArray(test1, "A"));
        assertEquals(1,App.isInArray(test1, "B"));
        assertEquals(2,App.isInArray(test1, "C"));
        assertEquals(-1,App.isInArray(test1, "D"));
    }
}