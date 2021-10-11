package org.example.ex046;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    AppTest() throws IOException {
    }
    String test= App.readFile("src/test/java/org/example/ex046/ex046_test_file.txt");
    //Expected results after calling the splitString function
    String split_test[]={"A", "B", "A","C", "B", "B", "B","D", "A", "C", "B"};
    //Expected results after calling the countWords function
    ArrayList<Word>count_test= new ArrayList<Word>() {
        {
            add(new Word("A", 3));
            add(new Word("B", 5));
            add(new Word("C", 2));
            add(new Word("D", 1));
        }
    };
    //Expected results after calling the sort function
    ArrayList<Word>sort_test= new ArrayList<Word>() {
        {
            add(new Word("B", 5));
            add(new Word("A", 3));
            add(new Word("C", 2));
            add(new Word("D", 1));
        }
    };

    @Test
    void splitString() {
        assertArrayEquals(split_test,App.splitString(test));
    }

    @Test
    void countWords() {
        //ArrayList to hold the expected results of a call on the split_test array above
        for (int i = 0; i < count_test.size(); i++) {
            assertEquals(count_test.get(i).getWord(),App.countWords(split_test).get(i).getWord());
            assertEquals(count_test.get(i).getNumOccurences(),App.countWords(split_test).get(i).getNumOccurences());
        }
    }

    @Test
    void sort() {
        for (int i = 0; i < sort_test.size(); i++) {
            assertEquals(sort_test.get(i).getWord(), App.sort(sort_test).get(i).getWord());
            assertEquals(sort_test.get(i).getNumOccurences(), App.sort(sort_test).get(i).getNumOccurences());
        }
    }

    @Test
    void checkforWord() {
        assertEquals(0,App.checkforWord(sort_test,"B"));
        assertEquals(1,App.checkforWord(sort_test,"A"));
        assertEquals(2,App.checkforWord(sort_test,"C"));
        assertEquals(3,App.checkforWord(sort_test,"D"));
    }
}