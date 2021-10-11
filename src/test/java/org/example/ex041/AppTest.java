package org.example.ex041;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void Sort() {
        ArrayList<String> sortTest= new ArrayList<String>();
        sortTest.add("A");
        sortTest.add("D");
        sortTest.add("B");
        sortTest.add("C");
        App.Sort(sortTest);

        ArrayList<String> sorted= new ArrayList<String>();
        sorted.add("A");
        sorted.add("B");
        sorted.add("C");
        sorted.add("D");

        for (int i = 0; i < sortTest.size(); i++) {
            assertEquals(sortTest.get(i),sorted.get(i));
        }
    }
}