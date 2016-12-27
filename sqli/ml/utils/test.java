package org.sqli.ml.utils;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class test {

    public static void main(String[] args)throws Exception{
        List<String> al = new ArrayList<>();
        al.add("a");
        al.add("b");
        al.add("c");
        al.add("d");

        List<String> sublist = al.subList(0, 3);  //inclusive index 0, exclusive index 3

        for(String s : sublist)
            System.out.println(s);
        System.out.println("================================================================");
        ////////////////////////////////////////////////////////////////////////////////////////////////

        String s = "AND LAST LINE NOT OR RANDNUM LAST LINE";
        String[] wordsArray = s.split("\\s+");
        List<Integer> wordFrequencyArrayList= new ArrayList<>();
        for(int i=0; i<wordsArray.length; i++){
            wordFrequencyArrayList.add(0);
        }
        System.out.println("size of wordFrequencyArrayList: " + wordFrequencyArrayList.size());
        for(int a: wordFrequencyArrayList){
            System.out.println("value of wordFrequencyArrayList: " + a);
        }

        int value = wordFrequencyArrayList.get(3);
        System.out.println("value: " + value);
        wordFrequencyArrayList.set(3,8);
        int newValue = wordFrequencyArrayList.get(3);
        System.out.println("newValue: " + newValue);

    }



}
