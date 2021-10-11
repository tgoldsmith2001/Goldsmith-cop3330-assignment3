package org.example.ex045;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createFile() throws IOException {
        ArrayList<String> test0= App.readFile("src/test/java/org/example/ex045/ex045_testFile.txt");
        assertEquals(true ,App.createFile(test0, "src/test/java/org/example/ex045","Output_Test"));
    }

    @Test
    void updateString() throws IOException {
        //Original File with A-Z in the file
        ArrayList<String> test1= App.readFile("src/test/java/org/example/ex045/ex045_testFile.txt");
        //File to test against... Instances of As are replaced by Bs
        ArrayList<String> testAgainst1= App.readFile("src/test/java/org/example/ex045/ex045_testFile_replaceAwithB.txt");
        ArrayList<String> updated= App.updateString(test1,"A","B");
        assertEquals(updated,testAgainst1);
    }
}