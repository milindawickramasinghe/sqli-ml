package org.sqli.ml.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.PrintWriter;

public class MatrixBuilder5 {

    public static String words ="";
    public static String s = "AND LAST LINE NOT OR RANDNUM";
    public static String[] wordsArray = s.split("\\s+");
    public static List<Integer> wordFrequencyArrayList= new ArrayList<>();
    public static List wordsList = Arrays.asList(wordsArray);
    public static String newline = System.getProperty("line.separator");

    public static void main(String[] args)throws Exception{

        for(int i=0; i<wordsArray.length; i++){
            wordFrequencyArrayList.add(0);
        }
        fileCrawler();
    }

    //read all URLs line by line, from file and put into small arrays
    public static String fileCrawler() throws FileNotFoundException {
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sample-sqli2.txt";
        BufferedReader BUFF_READER = null;
        String LINE = "";
        int inc = 1;
        int c = 0;

        ////////////////

        PrintWriter pw = new PrintWriter(new File("/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/test.csv"));
        StringBuilder sb = new StringBuilder();

        /////////////////

        try {
            BUFF_READER = new BufferedReader(new FileReader(INJECTION_FILE));

            while ((LINE = BUFF_READER.readLine()) != null) {
                String[] words = LINE.split("\\s+");
                for (String a : words){
                    if (wordsList.contains(a)){
                        c = wordsList.indexOf(a);
                        int value = wordFrequencyArrayList.get(c);
                        wordFrequencyArrayList.set(c,value+inc);
                    }
                }
                for(int w: wordFrequencyArrayList){
                    System.out.println("value of wordFrequencyArrayList: " + w);
                    sb.append(w);
                }
                System.out.println(newline);
                wordFrequencyArrayList.clear();
                for(int i=0; i<wordsArray.length; i++){
                    wordFrequencyArrayList.add(0);
                }
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (BUFF_READER != null) {
                try {
                    BUFF_READER.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //output all the arrays into a .csv file
    // https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/
}
