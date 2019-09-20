package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String filename;
        String str = "";
        ArrayList<String> list = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            filename = reader.readLine();
            reader.close();
            BufferedReader filereader = new BufferedReader(new FileReader(filename));
            while (filereader.ready()) {
                int x = filereader.read();
                if ((x > 96 && x < 123) || (x > 64 && x < 91))
                    str += Character.toString((char) x);
                else {
                    if (str.length() > 0) list.add(str);
                    str = "";
                }
            }
            if (str.length() > 0) list.add(str);
            filereader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        for (String s : list) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        int maxValue = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue() > maxValue) maxValue = entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() == maxValue) System.out.println(entry.getKey());
    }
}
