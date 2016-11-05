package org.milinda.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistogramCreator_7 {
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
                String[] keys = vulnerability.split(" ");
                String[] uniqueKeys;
                int count = 0;
                uniqueKeys = getUniqueKeys(keys);

                //Printing the line that is being processed
                System.out.println(vulnerability.toString());
                for(String key: uniqueKeys)
                {
                    if(null == key)
                    {
                        break;
                    }
                    for(String s : keys)
                    {
                        if(key.equals(s))
                        {
                            count++;
                        }
                    }
                    System.out.println("Count of ["+key+"] is : "+count);

                    count=0;
                }
                System.out.println("\n");
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

    private static String[] getUniqueKeys(String[] keys){
        String[] uniqueKeys = new String[keys.length];
        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;

        for(int i=1; i<keys.length ; i++)
        {
            for(int j=0; j<=uniqueKeyIndex; j++)
            {
                if(keys[i].equals(uniqueKeys[j]))
                {
                    keyAlreadyExists = true;
                }
            }

            if(!keyAlreadyExists)
            {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;
            }
            keyAlreadyExists = false;
        }
        return uniqueKeys;
    }
}
