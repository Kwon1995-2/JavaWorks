package com.tuyano.gradle;

class Person {
    private int weight;
    int age;
    protected  int height;
    public String name;
    public String job;
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
    public Person(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
//    public void showPerson() {
//        System.out.print("weight:"+weight+", ");
//    }
    public void show() {
        System.out.print("weight:"+weight+", ");
    }
}

class Student extends Person {
//    public void set() {
//        age = 30;
//        name = "Honggildong";
//        height = 175;
//        //weight = 99;
//        //setWeight(99);
//    }
    public Student(int weight,int age, String name, int height) {
        super(weight);
        this.age = age;
        this.name = name;
        this.height = height;
    }
//    public void showStudent() {
//        showPerson();
//        System.out.println("age:"+age+", name:"+name+", height:"+height);
//    }
    public void show() {
        //showPerson();
        super.show(); //front call
        System.out.print("age:"+age+", name:"+name+", height:"+height);
    }
}

class PartTimeStudent extends Student {
    public PartTimeStudent(int weight,int age, String name, int height, String job) {
        super(weight,age,name,height);
        this.job = job;
    }
    public void show() {
        super.show();
        System.out.println(", job:"+job);
    }
}

public class InheritanceEx {
    public static void main(String[] args) {
        //Student s = new Student(99,30,"HongGilDong",175);
        //s.set();
        //s.showStudent();
        PartTimeStudent ps = new PartTimeStudent(99,30,"HongGilDong",175,"BackSu");
        ps.show();
    }

}
