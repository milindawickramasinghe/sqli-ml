package org.sqli.ml.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MatrixBuilder4 {

    public static String words ="";
//    public static StringBuilder str = new StringBuilder("");
    //put unique words list into an array
//        http://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java
    public static String s = "AND LAST LINE NOT OR RANDNUM";
    public static String[] wordsArray = s.split("\\s+");
    public static List<Integer> wordFrequencyArrayList= new ArrayList<>();
    public static List wordsList = Arrays.asList(wordsArray);
    public static String newline = System.getProperty("line.separator");

    //crete an int array of the same size
    public static int[] matrixArray = new int[wordsArray.length];
    public static List matrixArrayList = Arrays.asList(matrixArray);

    public static int[] wordFrequencyArray = new int[wordsArray.length];

    public static void main(String[] args)throws Exception{

        for(int i=0; i<wordsArray.length; i++){
            wordFrequencyArrayList.add(0);
        }
        fileCrawler();
    }

    //read all URLs line by line, from file and put into small arrays
    public static String fileCrawler() {
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sample-sqli2.txt";
        BufferedReader BUFF_READER = null;
        String LINE = "";
        String NEW_LINE_SPLITTER = "\\\\r\\\\n";
        int inc = 1;
        int c = 0;

        try {
            BUFF_READER = new BufferedReader(new FileReader(INJECTION_FILE));

            while ((LINE = BUFF_READER.readLine()) != null) {
                String[] words = LINE.split("\\s+");
                for (String a : words){
                    if (wordsList.contains(a)){
                        c = wordsList.indexOf(a);
                        int value = wordFrequencyArrayList.get(c);
                        wordFrequencyArrayList.set(c,value+inc);
                        int value2 = wordFrequencyArrayList.get(c);
                    }
                }
                for(int w: wordFrequencyArrayList){
                    System.out.println("value of wordFrequencyArrayList: " + w);
                }
                System.out.println(newline);
                wordFrequencyArrayList.clear();
                for(int i=0; i<wordsArray.length; i++){
                    wordFrequencyArrayList.add(0);
                }
            }
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
}
