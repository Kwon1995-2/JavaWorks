package com.tuyano.gradle2;

class Shape {
    int snum;
    public Shape next;
    public Shape(int snum) {
        this.snum = snum;
        next = null;}

    public void draw() {
        System.out.println("Shape"+snum);
    }
}

class Line extends Shape {
    int lnum;
    public Line(int snum, int lnum) {
        super(snum);
        this.lnum = lnum;
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("Line"+lnum);
    }
}

class Rect extends Shape {
    int rnum;

    public Rect(int snum, int rnum) {
        super(snum);
        this.rnum = rnum;
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("Rect"+rnum);
    }
}

class Circle extends Shape {
    int cnum;
    public Circle(int snum, int cnum) {
        super(snum);
        this.cnum = cnum;
    }
    @Override
    public void draw() {
        super.draw();
        System.out.println("Circle"+cnum);
    }
}

public class MethodOverridingEx {
    static void paint(Shape p) {
        p.draw();
    }

    public static void main(String[] args) {
        Line line =new Line(2,3);

        paint(line);
        paint(new Shape(3));
        paint(new Line(4,5));
        paint(new Rect(6,7));
        paint(new Circle(7,8));
    }
}
