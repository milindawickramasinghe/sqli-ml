package org.milinda.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HistogramCreator_4 {
    public static String vulnerability="";

    public static void main(String[] args)throws Exception{
        inputProcessor();
        System.out.println("printing -4");
//        wordFrequencyCounter();
    }
    /**
     * read SQL injection file line by line
     *
     * put the result into an arraylist
     *
     * print the arraylist
     */

    /**
     * put a set of SQL injection vectors into an array list
     */
    public static String inputProcessor() {
//        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sql-i-list-1-boolean_blind.txt";
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/sample-sqli1.txt";
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
                vulnerability = vulnerability.trim();
//                output.add(vulnerability);
                /**
                 *
                 */
//                String text = output.toString();
                String[] keys = vulnerability.split(" ");
                String[] uniqueKeys;
                int count = 0;
//                System.out.println(text);
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
                /**
                 *
                 *
                 */
            }
//            System.out.println(output.toString());

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


    /**
     * print the arrayList
     */

    /**
     * create string out of arraylist
     *
     * read the string to count words
     */


//    public static void wordFrequencyCounter() throws IOException {
////            String text = "the quick brown fox jumps fox fox over the lazy dog brown";
//        String text = output.toString();
//        String[] keys = text.split(" ");
//        String[] uniqueKeys;
//        int count = 0;
//        System.out.println(text);
//        uniqueKeys = getUniqueKeys(keys);
//
//        for(String key: uniqueKeys)
//        {
//            if(null == key)
//            {
//                break;
//            }
//            for(String s : keys)
//            {
//                if(key.equals(s))
//                {
//                    count++;
//                }
//            }
//            System.out.println("Count of ["+key+"] is : "+count+"\n");
//            count=0;
//        }
//    }

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
