package com.tuyano.gradle2;

public class UsingOverride {
    public static void main(String[] args) {
        Shape start, last, obj;

        start = new Line(2,3); //first node
        last = start;
        obj = new Rect(3,4); //second node
        last.next = obj; //first - second link
        last = obj; //obj is assigned to last
        obj = new Line(4,5); //third node
        last.next = obj; //second - third link
        last = obj; //obj is assigned to last
        obj = new Circle(5,6); // fourth node
        last.next = obj; //third - fourth link

        Shape p = start;
        while(p != null) {
            p.draw();
            p = p.next;
        }
    }
}
