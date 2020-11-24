package com.company;

import java.io.*;

public class FileManager {
    public static void main(String[] args) {

    }

    // public static int countFiles(String path) - принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public static int countFiles(String path) throws IOException {

        File directory = new File(path);
        if (!directory.isDirectory()) throw new IllegalArgumentException("This isn't a directory.");
        int count = 0;
        File[] listOfElements = directory.listFiles();
        if (listOfElements != null) {
            for (File element: listOfElements) {
                if(element.isFile()) {
                    count++;
                } else {
                    count+=countFiles(element.getAbsolutePath());
                }
            }
        }

        return count;
    }

    // public static int countDirs(String path) - принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public static int countDirs(String path) throws IOException{
        File directory = new File(path);
        if (!directory.isDirectory()) throw new IllegalArgumentException("This isn't a directory.");
        int count = 0;
        File[] listOfElements = directory.listFiles();
        if (listOfElements != null) {
            for (File element: listOfElements) {
                if(element.isDirectory()) {
                    count++;
                    count+=countDirs(element.getAbsolutePath());
                }
            }
        }

        return count;
    }

    public static void copy(String from, String to) throws IOException {
        File copyFrom = new File(from);
        File copyTo = new File(to);
        if (!copyTo.isDirectory()) throw new IllegalArgumentException("This isn't a directory you are copying to.");
        if (!copyFrom.isDirectory() || !copyFrom.isFile()) throw new IllegalArgumentException("This isn't a file nor a directory you're copying.");
        FileReader readerFrom = new FileReader(copyFrom);
        FileWriter writerTo = new FileWriter(copyTo);
        int spaceRequired = (int) copyFrom.getTotalSpace();
        if (copyTo.getFreeSpace() < spaceRequired) throw new IllegalStateException("There isn't enough space in destination directory to copy all data into it.");
        char[] buff = new char[spaceRequired / 2];
        readerFrom.read(buff, 0, spaceRequired / 2);
        writerTo.write(buff, 0, spaceRequired / 2);
    }
}
