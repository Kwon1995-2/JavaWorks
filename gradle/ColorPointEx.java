package com.tuyano.gradle;

class Point {
    private int x,y;

    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
    public void set(int x, int y) {
        this.x = x; this.y = y;
    }
    public void showPoint() {
        System.out.println("("+x+","+y+")");
    }
}

class ColorPoint extends Point {
    private String color;
    public ColorPoint(int x, int y,String color) {
        super(x,y);
        this.color =color;
    }
    public void set(int x, int y,String color) {
        super.set(x,y);
        this.color =color;
    }
    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }
}

public class ColorPointEx {
    public static void main(String[] args) {
        //Point p = new Point(1,2);
        //p.set(1,2);
        //p.showPoint();

        ColorPoint cp = new ColorPoint(1,2,"red");
        //cp.set(3,4);
        //cp.setColor("red");
        cp.showColorPoint();
        cp.set(2,3,"blue");
        cp.showColorPoint();
    }
}
