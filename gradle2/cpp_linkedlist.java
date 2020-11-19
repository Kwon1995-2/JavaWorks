package com.tuyano.gradle2;

import java.util.*;

class Node { //constructor
    private int num;
    public Node next;
    //default constructor
    public Node() {this.num = (int)(Math.random()*10)+1; next=null;} // not right uses : (int)Math.random()*10+1
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
    //public void addNode(int data)
    //public void addNode()
    public void addNode(int data) { //it's my style
        //Node node = new Node(data); //plus front
        Node node = new Node(data);
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
    public void addNode2(int data) { //plus node behind
        Node node = new Node(data);
        Node temp; Node follow;
        if(first.next == null) {
            first.next = node;
        } else {
            temp = first.next;
            follow = temp;
            while(temp != null) {
                follow = temp;
                temp = temp.next;
            }
            follow.next = node;
        }
    };
    //showList
    public void showList() {
        int count = 0; //node count check
        Node temp = first.next; //start : first -> 1 more output
        while(temp != null) {
            System.out.printf("node%d:%d  ", count, temp.GetNum());
            //System.out.println("node:"+temp.GetNum());
            temp = temp.next;
            count++;
        }
        System.out.println();
    };
// numbers of Node in List must be known
//    public void sortList() {
//      Node copy = this.first.next;
//      Node follow = copy.next;
//      while(follow != null) {
//          if(copy.GetNum() > follow.GetNum()) {
//
//          }
//      }
//    };

    public List mergeList(List l) { //just cross node merge
        Node p = this.first.next; //if Node p = this.first --> num of first is printed;
        Node f = p.next;
        Node q = l.first.next;
        Node ff = q.next;
        while (p.next != null) { //p != null --> error because p is null : p=null --> null.next : error
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

    //descending
    public List mergesortList(List l) {
        Node p; Node temp; //Node pf;
        Node q; Node qf;
        int decision = 0;
        //bigger number setting
        if(this.first.next.GetNum() >= l.first.next.GetNum()) {
            p = this.first.next;
            q = l.first.next;
        } else {
            p = l.first.next;
            q = this.first.next;
            decision = 1;
        }
        temp = p; //pf = p.next;
        qf = q.next;
/////////////////////////////////////////////////////////////////////////////////////
//        Node start; //start point setting
//        if(p.GetNum() >= q.GetNum()) {start = p; p = p.next;}
//        else {start = q; q = q.next;}

//        while(p != null) {
//            if(p.GetNum() >= q.GetNum()) {
//                //temp = p;
//                p = p.next; pf = pf.next;
//            } else {
//                p.next = q;
//                q.next = pf;
//                p = pf;
//                q = qf;
//                pf = pf.next; qf = qf.next;
//                if(pf == null) {p.next = q; break;}
//                //if(qf == null) {q.next = p; break;}
//            }
/////////////////////////////////////////////////////////////////////////////////////
        while(p.next != null) { // --> while(true) --> don't care
            if(p.GetNum() >= q.GetNum()) { temp = p; p = p.next; //pf = pf.next;
            } else {
                temp.next = q; q.next = p; //linking
                temp = p; q = qf; //reassign
                p = p.next; qf = qf.next; //reassign
                if(p.next == null) {
                    temp.next = q; q.next = p;
                    if(qf != null) p.next = qf;
                    break;
                    }
                }
            }
        if(decision == 1) return l;
        else return this;
    };

}

public class cpp_linkedlist {
    public static Random rand = new Random();
    public static void MakeList(List l, int num) {
        int rnum;
        if(num%2 == 0) rnum = 2;
        else           rnum = 1;
        for(int i=0;i<num;i++) {
            //rnum = rand.nextInt(10) + 1;
            //l.addNode();
            l.addNode(rnum);
            //l.addNode2(rnum);
            rnum += 2;
        }
    }

    public static void main(String[] args) {
        List a1 = new List(); //reference variable : a1 <- address
        List a2 = new List();
        MakeList(a1, 10); //10: number of Node
        MakeList(a2,5);
        a1.showList();
        System.out.println();

        a2.showList();
        System.out.println();

//        addList test
//        a1.addList(a2).showList();
//        List a3 = a1.addList(a2);
//        a3.showList();
//        System.out.println();

        //mergeList test;
//        List a4 = a1.mergeList(a2); //a1 is changed
//        a4.showList();
//        System.out.println();
//        List a5 = a2.mergeList(a1);
//        a5.showList();


        //mergesortList test
        List a6 = a1.mergesortList(a2);
        a6.showList();
//        List a7 = a2.mergesortList(a1);
//        a7.showList();

//        List a5;
//        a5 = a4;

    }

}
