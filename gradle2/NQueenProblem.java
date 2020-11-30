package com.tuyano.gradle2;

public class NQueenProblem {

    private int N = 4;
    private int cols[] = new int[4];

    public static void main(String[] args) {
        NQueenProblem solution = new NQueenProblem();
        solution.backTracking(0);
    }

    public void backTracking(int row) { //0
        if(row == N) {
            for(int i=0;i<N;i++) {
                System.out.println(cols[i]);
            }
            System.out.println("");
        }
        else {
            for(int i=0;i<N;i++) {
                cols[row] = i;
                if(isPossible(row)) backTracking(row+1);
            }
        }
    }

    public boolean isPossible(int row) {
        for(int i=0;i<row;i++) {
            if(cols[i] == cols[row] || Math.abs(row-i) == Math.abs(cols[row] - cols[i])) {
                return false;
            }
        }
        return true;
    }
}
