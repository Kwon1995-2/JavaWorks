package com.tuyano.gradle3;
import java.util.*;
public class HashMapScoreEx {
    public static void main(String[] args) {
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

        scoreMap.put("김성동",97);
        scoreMap.put("황기태",88);
        scoreMap.put("감남윤",98);
        scoreMap.put("이재문",70);
        scoreMap.put("한원선",99);

        System.out.println("HashMap의 요소 개수 : "+scoreMap.size());

        Set<String> Keys = scoreMap.keySet(); //모든 키를 가진 Set 컬렉션 리턴
        Iterator<String> it = Keys.iterator();

        while(it.hasNext()) {
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name+" : "+score);
        }
    }
}
