
package com.company;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileAnalyzer {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("There is more or less than two arguments.");
        }
        File fileToAnalyze = new File(args[0]);
        String sample = args[1];

        String fileContent;
        fileContent = readFileIntoString(fileToAnalyze);

        printAmountOfInstances(getAmountOfInstances(fileContent, sample));
        printEverySentenceWithInstance(getSentencesWithInstances(fileContent, sample));

    }

    static String readFileIntoString(File fileToRead) throws IOException {
            FileReader fileReader = new FileReader(fileToRead);
            int fileLength = (int) fileToRead.length();
            char[] fileContent = new char[fileLength];
            fileReader.read(fileContent, 0, fileLength);
        System.out.println(fileContent);
            return String.valueOf(fileContent);

    }

    static String[] getSentencesWithInstances(String fileContent, String sample) {
        String regex = new StringBuilder().append("\\S.*").append(sample).append(".*(\\.|\\?|!)").toString();

        return fileContent.split(regex);
    }

    static int getAmountOfInstances(String fileContent, String sample) {
        Pattern instancePattern = Pattern.compile(sample);
        Matcher matcher = instancePattern.matcher(fileContent);
        return matcher.groupCount();
    }
    static void printAmountOfInstances(int amount) {
        System.out.println(amount);
    }
    static void printEverySentenceWithInstance(String[] sentencesWithInstances) {
        for (int i = 0; i < sentencesWithInstances.length; i++) {
            System.out.println(sentencesWithInstances[i]);
        }
    }
}
