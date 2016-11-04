package org.milinda.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistogramCreator {
    static String output="";

        public static void main(String[] args) throws IOException {
//            String text = "the quick brown fox jumps fox fox over the lazy dog brown";
            readLines();
            String text = output;
            String[] keys = text.split(" ");
            String[] uniqueKeys;
            int count = 0;
            System.out.println(text);
            uniqueKeys = getUniqueKeys(keys);

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
        }

        private static String[] getUniqueKeys(String[] keys)
        {
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





    public static String readLines() throws IOException {
        String INJECTION_FILE = "/home/milindaw/MSC-PROJECT/INPUT-VALIDATOR/Payload_extractor/sql-i-list-1-boolean_blind.txt";
        FileReader fileReader = new FileReader(INJECTION_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return output = String.valueOf(lines.toArray(new String[lines.size()]));
    }

//    public static List<String> inputProcessor() throws IOException {
//
////        List<String> output = new ArrayList<String>();
//        try {
//
//            BUFF_READER = new BufferedReader(new FileReader(INJECTION_FILE));
//            while ((LINE = BUFF_READER.readLine()) != null) {
//
//                // use new line as separator
//                String[] vulnerabilities = LINE.split(NEW_LINE_SPLITTER);
//
//                ArrayList<String[]> action = new ArrayList<String[]>();
//                action.add(vulnerabilities);
//                String vulnerability = Arrays.toString(action.get(0));
//                output.add(vulnerability);
////                System.out.println(Arrays.toString(action.get(0)));
////                return vulnerability;
//
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (BUFF_READER != null) {
//                try {
//                    BUFF_READER.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return output;
//    }
    }
