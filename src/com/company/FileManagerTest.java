package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    private String invalidPath = "NotAPath";
    private String pathToFile = "C:\\Users\\1\\Desktop\\test.txt";
    private String pathToEmptyDir = "C:\\Users\\1\\Desktop\\EmptyTestDir";
    private String pathToDir = "C:\\Users\\1\\Desktop\\TestDir";
    private String fromDir = "C:\\Users\\1\\Desktop\\Source";
    private String fromFile = pathToFile;
    private String fromEmptyDir = "C:\\Users\\1\\Desktop\\EmptyTestDir";
    private String toDir = "C:\\Users\\1\\Desktop\\Destination";
    private String toFile = pathToFile;



    @Test
    void testCountFilesOnInvalidPath(){
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.countFiles(invalidPath);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.countFiles(pathToFile);
        });
    }

    @Test
    void testCountDirsOnInvalidPath() {
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.countDirs(invalidPath);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.countDirs(pathToFile);
        });
    }

    @Test
    void testCountFilesOnEmptyDir() throws IOException {
        assertEquals(0, FileManager.countFiles(pathToEmptyDir));
    }

    @Test
    void testCountDirsOnEmptyDir() throws IOException {
        assertEquals(0, FileManager.countDirs(pathToEmptyDir));
    }

    @Test
    void testCountFiles() throws IOException{
        assertEquals(2, FileManager.countFiles(pathToDir));
    }

    @Test
    void testCountDirs() throws IOException{
        assertEquals( 2, FileManager.countDirs(pathToDir));
    }

    @Test
    void testCopyOnInvalidSource() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.copy(invalidPath, toDir);
        });
    }

    @Test
    void testCopyOnInvalidDestination() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.copy(fromDir, invalidPath);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FileManager.copy(fromDir, toFile);
        });
    }

    @Test
    void testCopyOnEmptySource() throws IOException {
    }

    @Test
    void testCopyOnDestinationWithoutEnoughFreeSpace() throws IOException {

    }

    @Test
    void testCopy() throws IOException {
        FileManager.copy("C:\\Users\\1\\Desktop\\Source", toDir);
        File destination = new File(toDir);
        String copiedFile = destination.list()[0];
        assertEquals("I want a twin!.txt", copiedFile);
        File[] files = destination.listFiles();
        for (File element: files) {
            element.delete();
        }
    }
}