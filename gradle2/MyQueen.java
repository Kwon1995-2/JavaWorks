package com.tuyano.gradle2;

import java.util.*;

public class MyQueen {

    private int size;
    private int[] array;
    Stack<Integer> stack;

    public MyQueen(int size) {
        this.size = size;
        array = new int[size*size];
        stack = new Stack<Integer>();
    }
    public void printQ() {
        //int size = (int)(Math.sqrt(array.length));
        System.out.println();
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                System.out.print(array[j+i*size]+" ");
            }
            System.out.print("\n");
        }
    }
    public void init() {
        for(int i=0;i<size*size;i++)
            array[i] = 0;
    }

    public void backTracking(int start) {
        if(stack.size() == size) {
            stack.clear();
            this.printQ();
            this.init();
            return;
        }

        for(int i=0;i<2;i++) { //4
            if(start >= size*size) {
                return;
            }
            stack.push(start);
            if(isValid(start)) {
                array[start]=1;
                if(start/size == 0) start = 0;
                else if(start/size ==1) start = 4;
                else if(start/size == 2) start = 8;
                else if(start/size == 3) start = 12;
                this.backTracking(start+size);
            } else {
                int idx = stack.pop();
                array[idx] = 0;
                this.backTracking(start+1);
            }
        }
    }

    public boolean isValid(int idx) {
        for(int i=0;i < idx;i++) {
            if(i >= size*size) return false;
            if ( (i/size == idx/size && array[i/size] == 1) || (i%size == idx%size && array[i%size] == 1) ||
                    (i%(size-1)==idx%(size-1) && array[i] == 1) || (i%(size+1)==idx%(size+1) && array[i] == 1) ){
                //System.out.print("idx:"+idx+",i:"+(i-size)+" ");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyQueen myqueen = new MyQueen(4);
        myqueen.backTracking(0);
    }

}
