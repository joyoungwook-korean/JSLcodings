package com.company.jsl_07.Day_0709.trema;

import java.util.*;

public class ScoresExam {
    public static void main(String[] args) {
        int num, kor, eng, mat, sie;
        String name;
        TreeMap<Student,Score> treeMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            num = scanner.nextInt();
            if(num==0) break;
            name = scanner.next();
            kor = scanner.nextInt();
            eng=  scanner.nextInt();
            mat = scanner.nextInt();
            sie = scanner.nextInt();
            Score score = new Score(kor,eng,mat,sie);
            treeMap.put(new Student(num,name),score);

        }
        Set set = treeMap.keySet();
        Iterator iterator = set.iterator();
        ArrayList<Integer> list= new ArrayList<>();

        Map.Entry entry;
        while (iterator.hasNext()){
            Object s = iterator.next();
            System.out.println(s + treeMap.get(s).toString());
            list.add(treeMap.get(s).getTot());
        }

       int max = Collections.max(list);
        System.out.println(max);
    }
}
