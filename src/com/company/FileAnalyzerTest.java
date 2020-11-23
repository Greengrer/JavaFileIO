package com.company;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileAnalyzerTest {

    @org.junit.jupiter.api.Test
    void testReadFileIntoString() throws IOException {
        //when
        File file = new File("C:\\Users\\1\\Desktop\\test.txt");
        //then
        assertEquals("Ducky day. No duck! Dramatic drunk.", FileAnalyzer.readFileIntoString(file));

    }

    @org.junit.jupiter.api.Test
    void testGetSentencesWithInstances() {
        //when
        String sample = "duck";
        String fileContent = "Ducky day. No duck! Dramatic drunk.";
        //then
        assertEquals("No duck!", FileAnalyzer.getSentencesWithInstances(fileContent, sample)[0]);
    }

    @org.junit.jupiter.api.Test
    void testGetAmountOfInstances() {
        //when
        String sample = "duck";
        String fileContent = "Ducky day. No duck! Dramatic drunk.";
        //then
        assertEquals(1, FileAnalyzer.getAmountOfInstances(fileContent, sample));
    }

    @org.junit.jupiter.api.Test
    void testPrintAmountOfInstances() {

    }

    @org.junit.jupiter.api.Test
    void testPrintEverySentenceWithInstance() {
    }
}