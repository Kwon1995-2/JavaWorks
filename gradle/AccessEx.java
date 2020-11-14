package com.tuyano.gradle;

class Sample {
    public int a;
    int b; //default : public
    int c;
}

public class AccessEx {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.a = 10;
        sample.b = 10;
        sample.c = 10;
        System.out.print("a:"+sample.a+" b:"+sample.b
        +" c:"+sample.c);
    }
}
