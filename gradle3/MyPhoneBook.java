package com.tuyano.gradle3;
import java.util.*;
public class MyPhoneBook {
    public static void main(String[] args) {
       HashMap<String, String> pb = new HashMap<String, String>();
       pb.put("000-111-1111","홍일동");
       pb.put("000-222-2222","홍이동");
       pb.put("000-333-3333","홍삼동");
       pb.put("000-444-4444","홍사동");
       pb.put("000-555-5555","홍오동");
       System.out.println("Prev Sort");
       Iterator<String> it = pb.keySet().iterator();
        LinkedList<String> lpb = new LinkedList<String>();
       while(it.hasNext()) {
           String num = it.next();
           String name = pb.get(num);
           lpb.add(num);
           System.out.println(num+","+name);
       }
       Collections.sort(lpb);
       it = lpb.iterator();
       int i = 0;
        System.out.println("After Sort");
       while(it.hasNext()) {
           String num = it.next();
           System.out.println(num+","+pb.get(num));
           i++;
       }
    }
}
