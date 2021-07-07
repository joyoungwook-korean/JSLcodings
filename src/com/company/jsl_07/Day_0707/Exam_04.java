package com.company.jsl_07.Day_0707;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Exam_04 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[] voca = {"rose", "candle", "paper", "book", "song", "candle",
                "berry", "paper", "berry", "song", "paper", "rose",
                "song", "lion", "berry", "rose", "book", "rose", "rose"};
        Iterator<String> iterator = Arrays.stream(voca).iterator();
        String s;
        while (iterator.hasNext()) {
            s = iterator.next();
            if (map.containsKey(s)) {
                int a = map.get(s);
                a++;
                map.put(s, a);
            } else {
                map.put(s, 1);
            }
        }
        Iterator<String> mapIterator = map.keySet().iterator();
        while (mapIterator.hasNext()) {
            String key = mapIterator.next();
            System.out.println(key + " : " + map.get(key) + " times");
        }


    }

}
