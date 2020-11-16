package com.tuyano.gradle2;

public class UsingOverride {
    public static void main(String[] args) {
        Shape start, last, obj;

        start = new Line(); //first node
        last = start;
        obj = new Rect(); //second node
        last.next = obj; //first - second link
        last = obj; //obj is assigned to last
        obj = new Line(); //third node
        last.next = obj; //second - third link
        last = obj; //obj is assigned to last
        obj = new Circle(); // fourth node
        last.next = obj; //third - fourth link

        Shape p = start;
        while(p != null) {
            p.draw();
            p = p.next;
        }
    }
}
