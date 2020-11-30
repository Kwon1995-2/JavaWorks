package com.tuyano.gradle2;

import java.util.*;

class Point {
    int row;
    int col;
    Point(int row, int col) {this.row = row; this.col = col;};
}

interface StackInterface { //No member variable
    public int Size();
    public boolean IsEmpty();
    public boolean IsFull();
    public Point Element(int idx);
    public void Push(Point x);
    public void Pop();
}

class MyStackQ implements StackInterface {
    int l;
    int size; //0
    int top;
    Point[] array;

    public MyStackQ(int l) {
        this.l = l;
        array = new Point[l];
        top = -1;
    }

    public int Size() {
        return this.size;
    }

    public boolean IsEmpty() {
        return this.size == 0;
    }

    public boolean IsFull() {
        return top + 1 == array.length;
    }

    public Point Element(int idx) {
        if (size - 1 < idx) {
            System.out.println("Invalid index!!!");
            return null;
        }
        System.out.print(this.array[idx]);
        return this.array[idx];
    }

    public void Push(Point x) {
        if (this.IsFull()) { //size == array.length
            System.out.println("Full stack!!!");
            return;
        }
        size += 1;
        top = size - 1;
        Point[] newarray = new Point[array.length];
        newarray[0] = x;
        for (int i = 1; i < size; i++) {
            newarray[i] = array[i - 1];
        }
        array = newarray;
    }

    public void Pop() {
        if (this.IsEmpty()) {
            System.out.println("Empty stack!!!");
            return;
        }
        size -= 1;
        top = size - 1;
        Point[] newarray = new Point[array.length];
        for (int i = 0; i < size; i++) {
            newarray[i] = array[i + 1];
        }
        array = newarray;
    }

    public void Show() {
        for (int i = 0; i < size; i++) {
            System.out.printf("row:%d->", this.array[i].row);
        }
        System.out.print("end\n");
    }
}


public class QueenProblem {
    //candidate

    //Valid check

    //print


    public static void SolveQueen(int[][] array, int size) {
        int r=0; int c=0;

        while(r <= size) {

        }
    }
    public static void main(String[] args) {
//        System.out.print("For N*N Array, Input N : ");
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int[][] array = new int[size][size];
        //2dim array
        //solveQueen <- array;
        System.out.print("For N*N Array, Input N : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] array; //int[] array = new int[size*size]; --> Pipe broken
        array = new int[size][size]; // 0 : initialize
        //printQ(array);
        SolveQueen(array, size);

    }
}
