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
//        if(stack.size() == size) {
//            stack.clear();
//            this.printQ();
//            this.init();
//            return;
//        }
//
//        for(int i=0;i<2;i++) { //4
//            if(start >= size*size) {
//                return;
//            }
//            stack.push(start);
//            if(isValid(start)) {
//                array[start]=1;
//                if(start/size == 0) start = 0;
//                else if(start/size ==1) start = 4;
//                else if(start/size  2) start = 8;
//                else if(start/size == 3) start = 12;
//                this.backTracking(start+size);
//            } else {
//                int idx = stack.pop();
//                array[idx] = 0;
//                this.backTracking(start+1);
//            }
//        }
        for(int i=0;i<size;i++) { // 4*4행렬은 성공
            stack.push(i);
            array[i] = 1; //0
            int temp = i/size + size; //4
            while(stack.size() != size) {
                if (temp >= size * size) break;
                stack.push(temp);
                array[temp] = 1;//4
                if(isValid(temp)) {
                    int r = (temp/size)*size+size;
                    if(r >= size*size) break;
                    temp = r;
                } else {
                    int c = stack.pop();
                    array[c] = 0;
                    if(c/size == (temp+1)/size) {
                        temp++;
                    } else {
                        int a = stack.pop();
                        array[a] = 0;
                    }
                }
            }
            if(stack.size() == size) this.printQ();
//            this.printQ();
            this.init();
            stack.clear();
        }
    }

    public boolean isValid(int idx) {
        for (int i = 0; i < idx; i++) {
            if (i >= size * size) return false;
//            if ( (i/size == idx/size && array[i/size] == 1) || (i%size == idx%size && array[i%size] == 1) ||
//                    (i%(size-1)==idx%(size-1) && array[i] == 1) || (i%(size+1)==idx%(size+1) && array[i] == 1) )
//            //////////////////////////////////////////////////////////////////////////////////////////////////////
            if ((i / size == idx / size && array[i] == 1) || (i % size == idx % size && array[i] == 1) ||
                    (idx - (size - 1) == i && array[i] == 1) || (idx - (size + 1) == i && array[i] == 1)) {
           //System.out.print("idx:"+idx+",i:"+(i-size)+" ");
                return false;
                }
//                //대각선 조건은 수정하면 열 수만큼 조건에 맞는 답이 나올 것(바로 위의 열 대각선만 체크함)
//            if(i%size == 0) {
//                if((i/size == idx/size && array[i] == 1) || (i%size == idx%size && array[i] == 1) ||
//                        (idx-i)%(size-1) == 0 && array[i] == 1) return false;
//            } else if(i%size == size-1) {
//                if((i/size == idx/size && array[i] == 1) || (i%size == idx%size && array[i] == 1) ||
//                        ((idx-i)%(size+1) == 0 && array[i] == 1)) return false;
//            } else{
//                if((i/size == idx/size && array[i] == 1) || (i%size == idx%size && array[i] == 1) ||
//                        ((idx-i)%(size-1) == 0 && array[i] == 1) || ((idx-i)%(size+1) == 0 && array[i] == 1))
//                    return false;
//            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyQueen myqueen = new MyQueen(4);
        myqueen.backTracking(0);
    }
}
