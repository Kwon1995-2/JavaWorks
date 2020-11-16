package com.tuyano.gradle2;

class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public void show() {
        System.out.print("Name:"+name+", ");
    }
}
class Student extends Person {
    private String major;
    public Student(String name, String major) {
        super(name);
        this.major = major;
    }
    public void show() {
        super.show();
        System.out.println("Student major:"+major);
    }
}
class Researcher extends Person {
    private String subject;
    public Researcher(String name, String subject) {
        super(name);
        this.subject = subject;
    }
    public void show() {
        super.show();
        System.out.print("subject:"+subject);
    }
}
class Professor extends Researcher {
    private String major;
    public Professor(String name, String subject, String major) {
        super(name, subject);
        this.major = major;
    }
    public void show() {
        super.show();
        System.out.println(", Professor major:"+major);
    }
}

public class InstanceOfEx {
//    static void print(Person p) {
//        if(p instanceof Person) System.out.print("Person ");
//        if(p instanceof Student) System.out.print("Student ");
//        if(p instanceof Researcher) System.out.print("Researcher ");
//        if(p instanceof Professor) System.out.print("Professor ");
//        System.out.println();
//    }

    public static void main(String[] args) {
//        System.out.print("new Student() ->\t"); print(new Student());
//        System.out.print("new Researcher() ->\t"); print(new Researcher());
//        System.out.print("new Professor() ->\t"); print(new Professor());
        Student s = new Student("HongGilDong","Management");
        Professor p = new Professor("KimJinWoo","Binary Option","Finance Management");
        s.show();
        p.show();
    }
}
