package org.example.ex043;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void makeDirectory() {
        assertTrue(App.makeDirectory("src/test/java/org/example/ex043","testFile"));
    }

    @Test
    void makeHtmlFile() throws IOException {
        assertTrue(App.makeHtmlFile("src/test/java/org/example/ex043/testFile","index","testFile1","Goldsmith"));
    }
}