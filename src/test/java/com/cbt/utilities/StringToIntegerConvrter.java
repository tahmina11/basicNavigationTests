package com.cbt.utilities;

import java.util.*;

public class StringToIntegerConvrter {
    public static List<Integer> convertToInt(List<String> listOfStrings){
        List<Integer> listOfNums = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
           listOfNums.add(Integer.parseInt(listOfStrings.get(i)));
        }
        return  listOfNums;
    }
}
