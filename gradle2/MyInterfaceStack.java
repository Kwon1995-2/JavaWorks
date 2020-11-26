package com.tuyano.gradle2;

import java.util.*;

interface ContainerInterface { //No member variable
    public int Size();
    public boolean IsEmpty();
    public boolean IsFull();
    public int Element(int idx);
    public void Push(int x);
    public void Pop();
}

//class MYStack implements ContainerInterface {
//    int size;
//    int top;
//    int[] array;
//
//    public MYStack(int size) {
//        array = new int[size];
//    }
//    public int Size() {
//        return this.size;
//    }
//    public boolean IsEmpty() {
//        return this.size == 0;
//    }
//    public boolean IsFull() {
//        return top+1 == array.length;
//    }
//    public int Element(int idx) {
//        if(size-1 < idx) {
//            System.out.println("Invalid index!!!");
//            return 0;
//        }
//        System.out.printf("index : %d -> value : %d\n", idx, this.array[idx]);
//        return this.array[idx];
//    }
//    public void Push(int x) {
//        if(this.IsFull()) { //size == array.length
//            System.out.println("Full stack!!!");
//            return;
//        }
//        size += 1;
//        top = size-1;
//        int[] newarray = new int[array.length];
//        newarray[0] = x;
//        for(int i=1;i<size;i++) {
//            newarray[i] = array[i-1];
//        }
//        array = newarray;
//    }
//    public void Pop() {
//        if(this.IsEmpty()) {
//            System.out.println("Empty stack!!!");
//            return;
//        }
//        size -= 1;
//        top = size-1;
//        int[] newarray = new int[array.length];
//        for(int i=0;i<size;i++) {
//            newarray[i] = array[i+1];
//        }
//        array = newarray;
//    }
//
//    public void Show() {
//        for(int i=0;i<size;i++) {
//            System.out.printf("%d->",this.array[i]);
//        }
//        System.out.print("end\n");
//    }
//}

class MYQueue implements ContainerInterface { //First In First out --> plus rear
    int size;
    int front;
    int rear;
    int[] array;

    public MYQueue(int size) {
        array = new int[size];
    }

    public int Size() {
        return this.size;
    }
    public boolean IsEmpty() {
        return this.size == 0;
    }
    public boolean IsFull() {
        return this.size == array.length;
    }
    public int Element(int idx) {
        if(size-1 < idx) {
            System.out.println("Invalid index!!!");
            return 0;
        }
        if(this.array[idx] == -1) {
            System.out.println("Empty cell!!!");
            return 0;
        }
        System.out.printf("index:%d -> value:%d\n", idx, this.array[idx]);
        return this.array[idx];
    }
    public void Push(int x) { //plus behind
        Scanner sc;
        //int[] newarray;
        if(this.IsFull()) { //size == array.length
            System.out.print("Full Queue now! if you push, you can't lost your front element.\n");
            System.out.print("Do you really want to push? [Y/N] ");
            sc = new Scanner(System.in);
            char input = sc.nextLine().charAt(0);
            if(input == 'Y' || input == 'y' ) {
                this.Pop();
//                newarray = new int[array.length];
//                for(int i=front;i<rear;i++) {
//                    newarray[i] = this.array[i+1];
//                }
//                newarray[size] = x;
//                this.array = newarray;
                this.array[rear] = x;
                size += 1; //Full Queue
                if(rear >= this.array.length-1) rear = 0;
                else rear += 1;
                System.out.println("Push front:"+front+", Push size:"+size+", Push rear:"+rear);
            } else if(input == 'N' || input == 'n') {
                System.out.println();
                return;
            } else {
                System.out.println("Please retry! We can't Push!");
                return;
            }
            return;
        }
        size += 1;
        array[rear] = x;
        if(rear >= this.array.length-1) rear = 0;
        else rear += 1;
        System.out.println("Push front:"+front+", Push size:"+size+", Push rear:"+rear);
    }
    public void Pop() { //front pop;
        if(this.IsEmpty()) {
            System.out.println("Empty Queue!!!");
            return;
        }
        size -= 1;
        array[front] = -1; //-1 Invalid value;
        if(front >= this.array.length-1) front = 0;
        else front += 1;
        //if(this.IsEmpty()) rear = 0;
        System.out.println("Pop front:"+front+", Pop size:"+size+", Push rear:"+rear);
    }

    public void Show() {
        for(int i=0;i<array.length;i++) {
            if(this.array[i] == -1) continue;
            System.out.printf("%d:%d->",i,this.array[i]);
        }
        System.out.print("end\n");
    }
}

public class MyInterfaceStack {
    public static void main(String[] args) {
//        Stack Test
//        MYStack mystack = new MYStack(3);
//        mystack.Push(1);
//        mystack.Push(2);
//        mystack.Push(3);
//        mystack.Show();
//        mystack.Push(4);
//        mystack.Pop();
//        mystack.Show();
//        mystack.Pop();
//        mystack.Show();
//        mystack.Pop();
//        mystack.Show();
//        mystack.Pop();
//        mystack.Element(0);
//        mystack.Element(1);
//        mystack.Element(2);
//        mystack.Element(3);

//        Queue Test
        MYQueue myqueue = new MYQueue(3);
        myqueue.Push(1);
        myqueue.Push(2);
        myqueue.Push(3);
        myqueue.Show();
        myqueue.Push(4);
        myqueue.Show();
        myqueue.Pop();
        myqueue.Show();
        myqueue.Element(1);
        myqueue.Pop();
        myqueue.Show();
        myqueue.Pop();
        myqueue.Show();
        myqueue.Pop();
        myqueue.Push(1);
        myqueue.Show();
    }
}
