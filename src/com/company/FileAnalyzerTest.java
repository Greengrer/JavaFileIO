package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileAnalyzerTest {

    @Test
    void testReadFileIntoString() throws IOException {
        //when
        File file = new File("C:\\Users\\1\\Desktop\\test.txt");
        //then
        assertEquals("Ducky day. No duck! Dramatic drunk.", FileAnalyzer.readFileIntoString(file));

    }

    @Test
    void testGetSentencesWithInstances() {
        //when
        String sample = "duck";
        String fileContent = "Ducky day. No duck! Dramatic drunk.";
        //then
        assertEquals("No duck!", FileAnalyzer.getSentencesWithInstances(fileContent, sample)[0]);
    }

    @Test
    void testGetAmountOfInstances() {
        //when
        String sample = "duck";
        String fileContent = "Ducky day. No duck! Dramatic drunk.";
        //then
        assertEquals(1, FileAnalyzer.getAmountOfInstances(fileContent, sample));
    }

    @Test
    void testPrintAmountOfInstances() {

    }

    @Test
    void testPrintEverySentenceWithInstance() {
    }
}