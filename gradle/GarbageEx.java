package com.tuyano.gradle;

public class GarbageEx {
    public static void main(String[] args) {
        String a = new String("Good");
        String b = new String("Bad");
        String c = new String("Normal");
        String d, e;
        d = c;
        e = null;
        System.out.print("a:"+a+" b:"+b+" c:"+c+" d:"+d+" e:"+e);
    }
}
