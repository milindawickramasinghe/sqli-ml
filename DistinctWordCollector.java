package org.milinda.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.Stream;
import java.util.stream.Collectors;

public class DistinctWordCollector {
    public static String vulnerability="";

    public static void main(String[] args)throws Exception{
        inputProcessor();
        System.out.println("printing -5");
    }

    public static String inputProcessor() {
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sql-i-list-1-boolean_blind.txt";
        BufferedReader BUFF_READER = null;
        String LINE = "";
        String NEW_LINE_SPLITTER = "\\\\r\\\\n";
        try {
            BUFF_READER = new BufferedReader(new FileReader(INJECTION_FILE));
            while ((LINE = BUFF_READER.readLine()) != null) {
                // use new line as separator
                String[] vulnerabilities = LINE.split(NEW_LINE_SPLITTER);
                ArrayList<String[]> VULNERABILITY_LIST = new ArrayList<String[]>();
                VULNERABILITY_LIST.add(vulnerabilities);
                vulnerability = Arrays.toString(VULNERABILITY_LIST.get(0));
                vulnerability = vulnerability.replaceAll("\\[(.*?)+","");
                vulnerability = vulnerability.replaceAll("\\]","");
                vulnerability = vulnerability.trim();


                //Printing the line that is being processed
                System.out.println(vulnerability.toString());

                List<String> list1 = Arrays.asList(vulnerability);
                List<String> list2 = list1.stream().distinct().collect(Collectors.toList());
                System.out.println(list2);
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
        return vulnerability;
    }

}
