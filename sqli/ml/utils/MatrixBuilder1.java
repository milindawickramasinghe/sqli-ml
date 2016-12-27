package org.sqli.ml.utils;

import java.io.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;


public class MatrixBuilder1 {
    public static int count = 0;
    public static String vulnerability="";
    public static StringBuilder str = new StringBuilder("");
    public static List sourceArrayList = new ArrayList();
    public static ArrayList<String[]> VULNERABILITY_LIST = new ArrayList<String[]>();
    public static List targetArrayList = new ArrayList();

    public static  Map<Integer, String[]> vulnerabilityHashMap = new HashMap<>();

    public static void main(String[] args)throws Exception{

        System.out.println("printing - DistinctWordCollector 5");
        countLines();
        fileCrawler();
        sourceArryaListBuilder();
    }

    public static int  countLines() throws IOException {
        String filename = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sample-sqli1.txt";
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
//            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            System.out.println(count);
            return count;
//            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static String fileCrawler() {
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sample-sqli1.txt";
        BufferedReader BUFF_READER = null;
        String LINE = "";
        String NEW_LINE_SPLITTER = "\\\\r\\\\n";

        try {
            BUFF_READER = new BufferedReader(new FileReader(INJECTION_FILE));

            while ((LINE = BUFF_READER.readLine()) != null) {
                String[] vulnerabilities = LINE.split(NEW_LINE_SPLITTER);

                VULNERABILITY_LIST.add(vulnerabilities);
                vulnerability = Arrays.toString(VULNERABILITY_LIST.get(0));
                vulnerability = vulnerability.replaceAll("\\[(.*?)+","");
                vulnerability = vulnerability.replaceAll("\\]","");
                vulnerability = vulnerability.trim();


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

    public static String hashMpaBuilder(){
        for (int i=0; i < count ; i++){
            str.append(" " + vulnerability);
            String allInOneString = str.toString();
            String[] allInOneArray = allInOneString.split("\\s+");
            vulnerabilityHashMap.put(i,allInOneArray);

        }

        return null;
    }

    public static String sourceArryaListBuilder(){

        hashMpaBuilder();
//  Java 8 with Lambda
//        vulnerabilityHashMap.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));

        for (Map.Entry<Integer, String[]> entry : vulnerabilityHashMap.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

        try {
            sourceArrayList = Arrays.asList(vulnerability);
            System.out.println(Arrays.toString(sourceArrayList.toArray()));



        } catch (PatternSyntaxException ex) {
        }
        return null;
    }


    public static String targetArrayListBuilder(){
        targetArrayList.add(vulnerability);
        System.out.println(Arrays.toString(targetArrayList.toArray()));

        return null;
    }

    public static String sourceAndTargetComparer(){

        return null;
    }

}
