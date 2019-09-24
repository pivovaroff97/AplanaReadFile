package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ReadWordsClass readWordsClass = new ReadWordsClass();
        ArrayList<String> list = readWordsClass.readFile();
        if (list.size() == 0) list = readWordsClass.readFile();
        TreeMap<String, Integer> map = readWordsClass.listToMap(list);
        readWordsClass.printWords(map);
    }
}
