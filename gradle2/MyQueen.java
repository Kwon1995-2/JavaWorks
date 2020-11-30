package com.tuyano.gradle2;

import java.util.*;

public class MyQueen {

    private int size;
    private int[] array;
    //int cnt;

    public MyQueen(int size) {
        this.size = size;
        array = new int[size*size];
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
    public void backTracking(int start) {
        if(start == size*size) {
            //cnt = 0;
            this.printQ();
            return;
        }

        for(int i=start;i<start + size;i=i++) { //4
            if(isValid(start)) {
                if(start == size*size) return;
                array[start]=1;
                this.backTracking(start+size);
            }
        }
    }

    public boolean isValid(int idx) {
        for(int i=0;i%size != idx%size;i++) {
            if (idx%size == (i-size)%size || Math.abs(idx-size-1)%size == (i-size)%size || Math.abs(idx-size+1)%size == (i-size)%size){
                //System.out.print("idx:"+idx+",i:"+(i-size)+" ");
                return false;
            }
        }
        //cnt++;
        return true;
    }

    public static void main(String[] args) {
        MyQueen myqueen = new MyQueen(4);
        myqueen.backTracking(0);
    }

}
