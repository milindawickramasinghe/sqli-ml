package org.sqli.ml.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MatrixBuilder2 {

    public static int count = 0;
    public static String words ="";
    public static StringBuilder str = new StringBuilder("");
    public static List sourceArrayList = new ArrayList();
//    public static ArrayList<String[]> wordsList = new ArrayList<String[]>();
    public static List targetArrayList = new ArrayList();

    public static Map<Integer, String[]> vulnerabilityHashMap = new HashMap<>();


    //put unique words list into an array
//        http://stackoverflow.com/questions/4674850/converting-a-sentence-string-to-a-string-array-of-words-in-java
    public static String s = "AND LAST LINE NOT OR RANDNUM LAST LINE";
    public static String[] wordsArray = s.split("\\s+");
    public static List wordsList = Arrays.asList(wordsArray);

    //crete an int array of the same size
    public static int[] matrixArray = new int[wordsArray.length];

    public static void main(String[] args)throws Exception{

        System.out.println(Arrays.toString(wordsArray));
//        System.out.println(Arrays.toString(matrixArray));

        fileCrawler();
    }

    //read all URLs line by line, from file and put into small arrays
    public static String fileCrawler() {
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sample-sqli2.txt";
        BufferedReader BUFF_READER = null;
        String LINE = "";
        String NEW_LINE_SPLITTER = "\\\\r\\\\n";

        try {
            BUFF_READER = new BufferedReader(new FileReader(INJECTION_FILE));

            while ((LINE = BUFF_READER.readLine()) != null) {
                String[] words = LINE.split("\\s+");

                for (String a : words){
                    if (wordsList.contains(a)){
                        System.out.println(a);
                    }
                }
            }



//            String[] vulnerabilityArray = words.split("\\s+");;
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
