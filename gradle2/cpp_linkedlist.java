package com.tuyano.gradle2;

import java.util.*;

class Node { //constructor
    private int num;
    public Node next;
    public Node() {this.num = (int)Math.random()*10+1; next=null;} // --> same value assign
    public Node(int num) {this.num = num; next=null;}
    public int GetNum() {
        return num;
    }
}

class List { //List a1 = new List();
    private Node first;
    //default constructor
    public List() {
       this.first = new Node();
    };
    //overloading constructor
    public List(int num) {
        this.first = new Node(num);
    };
    //copy constructor --> retry
//    public List(List l) {
//        l=this;
//    }
    //addList
    public List addList(List l) {
        Node temp = this.first;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = l.first.next;
        return this;
    };
    //addNode
    public void addNode(int data) {
        Node node = new Node(data); //plus behind
        node.next = first.next;
        first.next = node;
//        Node temp = first;
////        while(temp != null) {
////            System.out.println(temp.GetNum());
////            temp = temp.next;
////        }
////        temp = node;
//        while(temp.next != null) {
//            System.out.println(temp.GetNum());
//            temp = temp.next;
//        }
//        temp.next = node;
    };
    //showList
    public void showList() {
        int count = 0;
        Node temp = first.next; //start : first -> 1 more output
        while(temp != null) {
            System.out.printf("node%d:%d  ", count, temp.GetNum());
            //System.out.println("node:"+temp.GetNum());
            temp = temp.next;
            count++;
        }
        System.out.println();
    };

    public List mergeList(List l) {
        Node p = this.first.next; //if Node p = this.first --> num of first is printed;
        Node f = p.next;
        Node q = l.first.next;
        Node ff = q.next;
        while (p.next != null) { //p != null --> error
            p.next = q;
            q.next = f;
            p = f;
            q = ff;
            f = f.next; ff = ff.next;
            if(q.next == null) { p.next = q; q.next = f; break; }
            if(p == null) { p.next = q; break; }
        }
    return this;
    };

}

public class cpp_linkedlist {
    public static Random rand = new Random();
    public static void MakeList(List l, int num) {
        int rnum;
        for(int i=0;i<num;i++) {
            rnum = rand.nextInt(10) + 1;
            //l.addNode();
            l.addNode(rnum);
        }
    }

    public static void main(String[] args) {
        List a1 = new List();
        List a2 = new List();
        MakeList(a1, 10); //10: number of Node
        MakeList(a2,5);
        a1.showList();
        System.out.println();
        a2.showList();
        System.out.println();
        //a1.addList(a2).showList();
//        List a3 = a1.addList(a2);
//        a3.showList();
//        System.out.println();
//        List a4 = a1.mergeList(a2);
//        a4.showList();
        List a5 = a2.mergeList(a1);
        a5.showList();
//        List a5;
//        a5 = a4;

    }

}
