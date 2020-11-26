package com.tuyano.gradle2;

abstract class ContainerAbstract {
    int size;
    int top;

    public ContainerAbstract() {}
    public int Size() {return top+1;}
    public boolean IsEmpty() {return size == 0;}
    public abstract int Element(int idx);
    public abstract void Push(int value);
    public abstract void Pop();
}

class MyStack extends ContainerAbstract {
    int[] array;

    public MyStack(int size) {
        array = new int[size];
    }

    @Override //--> same name check
    public int Element(int idx){ //index --> value show
        if(size-1 < idx) {
            System.out.println("Invalid index!!!");
            return 0;
        }
        System.out.printf("index : %d -> value : %d\n", idx, this.array[idx]);
        return this.array[idx];
    };
    @Override
    public void Push(int x) {
        if(size == array.length) {
            System.out.println("Full stack!!!");
            return;
        }
        super.size += 1;
        int[] newarray = new int[array.length];
        newarray[0] = x;
        for(int i=1;i<size;i++) {
            newarray[i] = array[i-1];
        }
        array = newarray;
    };
    @Override
    public void Pop(){
        if(this.IsEmpty()) {
            System.out.println("Empty stack!!!");
            return;
        }
        super.size -= 1;
        int[] newarray = new int[array.length];
        for(int i=0;i<size;i++) {
            newarray[i] = array[i+1];
        }
        array = newarray;
    };

    public void Show() {
        for(int i=0;i<size;i++) {
            System.out.printf("%d->",this.array[i]);
        }
        System.out.print("end\n");
    }
}

public class MyAbstractStack {
    public static void main(String[] args) {
        MyStack mystack = new MyStack(3);
        mystack.Push(1);
        mystack.Push(2);
        mystack.Push(3);
        mystack.Show();
//        mystack.Push(4);
        mystack.Pop();
        mystack.Show();
        mystack.Pop();
        mystack.Show();
        mystack.Pop();
        mystack.Show();
        mystack.Pop();
//        mystack.Element(0);
//        mystack.Element(1);
//        mystack.Element(2);
//        mystack.Element(3);
    }
}
