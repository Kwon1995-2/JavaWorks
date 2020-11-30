package com.tuyano.gradle3;

import java.util.*;

public class VectorEx2 {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        //Iterator<Integer> it = v.iterator(); --> error
        //random push & print
        for(int i=0;i<5;i++) {
            int n = (int)(Math.random()*10);
            v.add(Integer.valueOf(n));
            //System.out.println(n);
        }
        Iterator<Integer> it = v.iterator();
        while(it.hasNext()) {
            int n = it.next();
            System.out.println(n);
        }
        int sum = 0;
        int max = 0;
        it = v.iterator();
        while(it.hasNext()) {
            int n = it.next();
            if(n >= max) max = n;
            sum += n;
        }
        System.out.println("sum:"+sum+", mean:"+(sum/v.size())+", max:"+max);
//        //max
//        int max = v.get(0);
//        for(int i=1;i<v.size();i++) {
//            if(v.get(i) >= max) {
//                max = v.get(i);
//            }
//        }
//        System.out.println("max value : "+max);
//
//        //sum, mean
//        int sum = 0;
//        for(int i=0;i<v.size();i++){
//            int n = v.elementAt(i);
//            sum += n;
//        }
//        System.out.println("sum : "+ sum+", mean : "+(sum/v.size()));
    }
}
