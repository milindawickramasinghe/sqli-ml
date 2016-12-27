package org.sqli.ml.utils;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MatrixBuilder3 {

    public static String words ="";
    public static StringBuilder str = new StringBuilder("");
    public static Map<Integer, String[]> vulnerabilityHashMap = new HashMap<>();


    //put unique words list into an array
//        http://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java
    public static String s = "AND LAST LINE NOT OR RANDNUM";
    public static String[] wordsArray = s.split("\\s+");
    public static List<Integer> wordFrequencyArrayList= new ArrayList<>();
    public static List wordsList = Arrays.asList(wordsArray);

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


                System.out.println(Arrays.toString(words));
                for (String a : words){
                    if (wordsList.contains(a)){
                        c = wordsList.indexOf(a);
                        System.out.println("index of " + a + " = " + c);
                        System.out.println("c = " + c);
                        int value = wordFrequencyArrayList.get(c);
                        System.out.println("OLD index of wordFrequencyArrayList index c = " + value);
                        wordFrequencyArrayList.set(c,value+inc);
                        int value2 = wordFrequencyArrayList.get(c);
                        System.out.println("NEW index of wordFrequencyArrayList index c = " + value2);
                    }

                }
                for(int w: wordFrequencyArrayList){
                    System.out.println("value of wordFrequencyArrayList: " + w);
                }
                wordFrequencyArrayList.clear();
                for(int i=0; i<wordsArray.length; i++){
                    wordFrequencyArrayList.add(0);
                }
            }
//            System.out.println("");
//            System.out.println("SIZE OF wordFrequencyArrayList: " + wordFrequencyArrayList.size());
//            for(int a: wordFrequencyArrayList){
//                System.out.println("value of wordFrequencyArrayList: " + a);
//            }

//            matrixArrayList.set(i, matrixArrayList.get(i) + count);
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

    //search for each element of the small arrays in the large array and increment the value of the corresponding index

    //output all the arrays into a .csv file
}
