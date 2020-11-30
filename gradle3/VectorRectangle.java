package com.tuyano.gradle3;

import java.util.Iterator;
import java.util.Vector;
import java.lang.Math;

class Rectangle {
    int x, y;
    int x2, y2;
    public Rectangle() {
        x = (int)(Math.random()*100);
        y = (int)(Math.random()*100);
        x2 = (int)(Math.random()*100);
        y2 = (int)(Math.random()*100);
    }
}
public class VectorRectangle {
    public static void main(String[] args) {
        Vector<Rectangle> r = new Vector<Rectangle>();
        Vector<Integer> area = new Vector<Integer>();
        int n = 0;
        while(n < 5) { //r.size() --> 0 ... : My mistake
            r.add(new Rectangle());
            System.out.println(r.get(n).x +","+ r.get(n).y+","+r.get(n).x2+","+r.get(n).y2);
            n++;
        }
        Iterator<Rectangle> it = r.iterator();
        int i = 0;
        while(it.hasNext()) {
            Rectangle rr = it.next();
            int width = Math.abs(rr.x - rr.x2);
            int height = Math.abs(rr.y - rr.y2);
            area.add(width*height);
            System.out.println("area:"+area.get(i));
            i++;
        }
        Iterator<Integer> it2 = area.iterator();
        int max = 0;
        int sum = 0;
        while(it2.hasNext()) {
            int num = it2.next();
            if(num >= max) max = num;
            sum += num;
        }
        System.out.println("max Rectangle:"+max+", mean Rectangle:"+(sum/area.size()));
//        for(int i=0;i<r.size();i++) {
//            int width = Math.abs(r.get(i).x - r.get(i).x2);
//            int height = Math.abs(r.get(i).y - r.get(i).y2);
//            area.add(width*height);
//            System.out.println("area:"+area.get(i));
//        }
        //System.out.println(r.get(0).x +","+ r.get(0).y+","+r.get(0).x2+","+r.get(0).y2);
//        int max = 0;
//        int sum = 0;
//        for(int i=0;i<area.size();i++) {
//            int temp = area.get(i);
//            if(temp >= max) max = temp;
//            sum += temp;
//        }
//        System.out.println("max Rectangle:"+max+", mean Rectangle:"+(sum/area.size()));
    }
}
