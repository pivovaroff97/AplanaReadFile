package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ReadWordsClass {

    private boolean isSecondTry;

    public void printWords(TreeMap<String, Integer> map) {
        int maxValue = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("File has word '" + entry.getKey() + "' " + entry.getValue() + " times");
            if (entry.getValue() > maxValue) maxValue = entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() == maxValue)
                System.out.println("Max count word is '" + entry.getKey() + '\'');
    }

    public TreeMap<String, Integer> listToMap(ArrayList<String> list) {
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String s : list) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        return map;
    }

    public ArrayList<String> readFile() {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader filereader = new BufferedReader(new FileReader(reader.readLine()));
            try {
                while (filereader.ready()) {
                    int x = filereader.read();
                    if (((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) || ((x >= 'а' && x <= 'я') || (x >= 'А' && x <= 'Я')))
                        str += Character.toString((char) x).toLowerCase();
                    else {
                        if (str.length() > 0) list.add(str);
                        str = "";
                    }
                }
                if (str.length() > 0) list.add(str);
            }
            finally {
                reader.close();
                filereader.close();
            }
        }
        catch (FileNotFoundException e) {
            if (!isSecondTry) System.out.println("Файл не найден, попробуйте снова");
            else System.out.println("Файл не найден");
            isSecondTry = true;
        }
        catch (IOException e) { e.printStackTrace(); }
        return list;
    }
}
