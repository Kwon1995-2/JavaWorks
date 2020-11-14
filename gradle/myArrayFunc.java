package com.tuyano.gradle;

class myArray {
    private int row; private int col;
    int [] array;
    public myArray(int r, int c) {
        this.row = r;
        this.col = c;
        array = new int[r * c];
    }

    public void init() {
        for(int i=0;i<row*col;i++)
            array[i] = (int)(Math.random()*3+1);
    }

    public myArray Add(myArray array2) {
        int size = this.row*this.col;
        //myArray newer = new myArray(this.row, this.col);
        //if( size != array2.length*array2[0].length) return;
        for(int i=0;i<size;i++)
            this.array[i] += array2.array[i];
        return this;
    }

    public myArray Mul(myArray arr1, myArray arr2) {
        for(int newrow=0;newrow<this.row;newrow++) //3
            for(int newcol=0;newcol<this.col;newcol++) //3
                for(int common=0;common<arr1.col;common++) //2
                    this.array[newrow*this.col+newcol] += arr1.array[newrow*arr1.col+common]*arr2.array[common*this.col+newcol];
        return this;
    }

    public void view() {
        for(int i=0;i<this.row;i++) {
            for (int j=0;j<this.col;j++)
                System.out.print(this.array[this.col * i + j] + " ");
            System.out.println();
        }
    }
}



public class myArrayFunc {

    public static void main(String[] args) {
//        myArray arr1 = new myArray(2,3);
//        myArray arr2 = new myArray(2,3);
//        myArray arr3 = new myArray(2,3);
//        arr1.init();
//        arr1.view();
//        arr2.init();
//        arr2.view();
//        System.out.println();
//        arr3 = arr1.Add(arr2);
//        arr1.view();
//        System.out.println();
//        arr3.view();

        myArray arr4 = new myArray(3,2);
        myArray arr5 = new myArray(2,3);
        myArray arr6 = new myArray(3,3);
        arr4.init();
        arr5.init();
        arr6.Mul(arr4,arr5);
        arr4.view();
        System.out.println();
        arr5.view();
        System.out.println();
        arr6.view();

    }
}

//    public static int[][] add(int[][] array1, int[][] array2) {
//        int row1 = array1.length; int col1 = array1[0].length;
//        int row2 = array2.length; int col2 = array2[0].length;
//        if(row1 != row2 || col1 != col2)
//            row1 = 0; col2 = 0;
//
//        int[][] newarray = new int[row1][col2];
//        for(int i=0;i<row1;i++)
//            for(int j=0;j<col2;j++)
//                newarray[i][j] = array1[i][j]+array2[i][j];
//        return newarray;
//    }
