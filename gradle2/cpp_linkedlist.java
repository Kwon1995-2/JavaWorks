package com.tuyano.gradle2;

import java.util.*;

class Node { //constructor
    private int num; //data
    public Node next;
    //default constructor
    public Node() {this.num = (int)(Math.random()*10)+1; next=null;} // not right uses : (int)Math.random()*10+1
    public Node(int num) {this.num = num; next=null;}
    public int GetNum() {
        return num;
    }
}

class List { //List a1 = new List();
    private Node first;

    //default constructor
    public Node GetFirst() {
        return first;
    }

    public void SetFirst(Node first) {
        this.first = first;
    }

    public List() {
        this.first = new Node();
    };

    //overloading constructor
    public List(int num) {
        this.first = new Node(num);
    };

    //copy constructor --> retry
    public List(List l) {
        this.first = new Node(l.first.GetNum());
        Node m = this.first;
        Node p = l.first.next;
        while (p != null) {
            Node nd = new Node(p.GetNum());
            m.next = nd;
            m = nd;
            p = p.next;
        }
    }

    //addList
//    public List addList(List l) {
//        Node temp = this.first;
//        while(temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = l.first.next;
//        return this;
//    };
    public List addList(List l) {
        Node temp = this.first;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node p = l.first.next; //only parameter copy constructor??
        while (p != null) {
            Node nd = new Node(p.GetNum());
            temp.next = nd;
            temp = nd;
            p = p.next;
        }
        return this;
    };

    //addNode
    //public void addNode(int data)
    //public void addNode()
    public void addNode(int data) { //it's my style
        //Node node = new Node(data); //plus front
        Node node = new Node(data);
        node.next = first.next;
        first.next = node;
//        Node temp = first;
////        while(temp != null) {
////            System.out.println(temp.GetNum());
////            temp = temp.next;
////        }
////        temp = node;
//        while(temp.next != null) {
//            System.out.println(temp.GetNum());
//            temp = temp.next;
//        }
//        temp.next = node;
    }

    ;

    public void addNode2(int data) { //plus node behind
        Node node = new Node(data);
        Node temp;
        Node follow;
        if (first.next == null) {
            first.next = node;
        } else {
            temp = first.next;
            follow = temp;
            while (temp != null) {
                follow = temp;
                temp = temp.next;
            }
            follow.next = node;
        }
    }

    ;

    //showList
    public void showList() {
        int count = 0; //node count check
        Node temp = first.next; //start : first -> 1 more output
        if (temp == null) return;
        while (temp != null) {
            System.out.printf("node%d:%d  ", count, temp.GetNum());
            //System.out.println("node:"+temp.GetNum());
            temp = temp.next;
            count++;
        }
        System.out.println();
    }

    ;
// numbers of Node in List must be known
//    public void sortList() {
//      Node copy = this.first.next;
//      Node follow = copy.next;
//      while(follow != null) {
//          if(copy.GetNum() > follow.GetNum()) {
//
//          }
//      }
//    };

    public List mergeList(List l) { //just cross node merge
        Node p = this.first.next; //if Node p = this.first --> num of first is printed;
        Node f = p.next;
        Node q = l.first.next;
        Node ff = q.next;
        while (p.next != null) { //p != null --> error because p is null : p=null --> null.next : error
            p.next = q;
            q.next = f;
            p = f;
            q = ff;
            f = f.next;
            ff = ff.next;
            if (q.next == null) {
                p.next = q;
                q.next = f;
                break;
            }
            if (p == null) {
                p.next = q;
                break;
            }
        }
        return this;
    };

    //descending
    public List mergesortList(List l) {
        Node p;
        Node temp; //Node pf;
        Node q;
        Node qf;
        int decision = 0;
        //bigger number setting
        if (this.first.next.GetNum() >= l.first.next.GetNum()) {
            p = this.first.next;
            q = l.first.next;
        } else {
            p = l.first.next;
            q = this.first.next;
            decision = 1;
        }
        temp = p; //pf = p.next;
        qf = q.next;
/////////////////////////////////////////////////////////////////////////////////////
//        Node start; //start point setting
//        if(p.GetNum() >= q.GetNum()) {start = p; p = p.next;}
//        else {start = q; q = q.next;}

//        while(p != null) {
//            if(p.GetNum() >= q.GetNum()) {
//                //temp = p;
//                p = p.next; pf = pf.next;
//            } else {
//                p.next = q;
//                q.next = pf;
//                p = pf;
//                q = qf;
//                pf = pf.next; qf = qf.next;
//                if(pf == null) {p.next = q; break;}
//                //if(qf == null) {q.next = p; break;}
//            }
/////////////////////////////////////////////////////////////////////////////////////
        while (p.next != null) { // --> while(true) --> don't care  while (p.next != null)
            if (p.GetNum() >= q.GetNum()) {
                temp = p;
                p = p.next; //pf = pf.next;
            } else {
                temp.next = q;
                q.next = p; //linking
                temp = p;
                q = qf; //reassign
                p = p.next;
                qf = qf.next; //reassign
                if (p.next == null) {
                    temp.next = q;
                    q.next = p;
                    if (qf != null) p.next = qf;
                    break;
                }
            }
        }
        if (decision == 1) return l;
        else return this;
    };

    public int GetCount() {
        Node p = this.first.next;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    };

    public List[] Split(List[] l) { //only 2 split -- only even
        if (l[0] == null) {
            l[0] = this;
            return l;
        }
        List[] ll = new List[l.length]; //8
        int size;
        int count;
        Node p = this.first.next;
        for (int i = 0; i < l.length; i = i + 2) {
            if (l[(int) i / 2] == null) break;
            ll[i] = new List(this.GetFirst().GetNum());
            ll[i + 1] = new List(this.GetFirst().GetNum());
            //int idx = i / 2; --> half doesn't seen
            size = l[i/2].GetCount() / 2; //4
            count = 0;
            while (count != size) {
                ll[i].addNode2(p.GetNum());
                p = p.next;
                count++;
            }
            count = 0;
            //if (size % 2.0 != 0) size--; // --> odd but doesn't work
            while (count != size) {
                ll[i + 1].addNode2(p.GetNum());
                p = p.next;
                count++;
            }
            //ll[i+1].first.next = p;
        }
        return ll;
    };

    public List[] mergesort(List[] l) {
        List[] ll = new List[l.length]; //8
        int size = l[0].GetCount();
        int count;
        for (int i = 0; i < l.length; i = i + 2) {
            if(l[i] != null ) {
                if(l[i+1] == null) ll[i/2] = l[i];
                else ll[(int)i/2] = new List(l[i].Sort(l[i+1]));
            }
            //ll[i/2] = l[i].mergesortList(l[i+1]);
            //ll[i/2] = new List(ll[i/2].Sort());
        }
        return ll;
    };

    public List Sort(List l) {
        Node p; Node pf;
        Node q; Node qf;
        Node ret;
        int decision = 0;
        //bigger number setting
        if (this.first.next.GetNum() <= l.first.next.GetNum()) {
            p = this.first.next; ret = p;
            q = l.first.next;
        } else {
            p = l.first.next; ret = p;
            q = this.first.next;
            decision = 1;
        }
        pf = p;
        qf = q;
        do {
            if(ret == p) {
                if (pf.GetNum() <= q.GetNum()) {
                    pf = p;
                    p = p.next;
                    if (p == null) {
                        p.next = q;
                        break;
                    }
                } else {
                    pf = p;
                    p = p.next;
                    ret.next = q;
                    ret = q;
                    }
                } else if(ret == q) {
                if (qf.GetNum() <= p.GetNum()) {
                    qf = q;
                    q = q.next;
                    if (pf == null) {
                        p.next = q;
                        break;
                    }
                } else {
                    q = qf; qf = qf.next;
                    ret.next = p;
                    ret = p;
                    }
                }
            }while (qf != null);
        if (decision == 1) return l;
        else return this;
    };

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
class ListIterator {
    private List list;
    private Node current;
    public Node GetNode() {return current;}
    ListIterator(List l) {this.list = l; current = l.GetFirst().next;}

    public boolean NotNull() { //constructor only
        if(current != null) {return true;}
        else return false;
    };
    public boolean NextNotNull(){ //constructor next once only
        if(current.next != null) {return true;}
        else return false;
    };

//    public boolean NotNull(Node n) { //check current element in list is non-null
//        if(n != null) return true;
//        else return false;
//    };
//    public boolean NextNotNull(Node n){ //check next element in list is non-null
//        if(n.next != null) return true;
//        else return false;
//    };

    public int First() {
        //Node p = new Node();
        //p = current;
        return current.GetNum();}; // stay
    public int Next() {
        current = current.next;
        return current.GetNum();
        };
    //public Node First(Node n) {return n;};
    //public Node Next(Node n) {return n.next;};

    public void showListIterator() {
//        Node temp = current;
//        System.out.println(this.First().GetNum());
//        while(temp != null) {
//            //System.out.printf("node%d:%d  ", count, temp.GetNum());
//            System.out.print("CNull:" + NotNull(temp) + ", NNull:" + NextNotNull(temp));
//            System.out.println();
//            if(temp.next != null) System.out.println(this.Next(temp).GetNum());
//            temp = temp.next;
//            //l.Next();
//        }
        Node temp = current;
        System.out.println(this.First());
        while(temp != null) {
            //System.out.printf("node%d:%d  ", count, temp.GetNum());
            System.out.print("CNull:" + this.NotNull() + ", NNull:" + this.NextNotNull());
            System.out.println();
            if(temp.next != null) System.out.println(Next());
            temp = temp.next;
            //l.Next();
        }
    }
}

public class cpp_linkedlist {
    public static Random rand = new Random();

    public static void MakeList(List l, int num) {
        int rnum;
//        if(num%2 == 0) rnum = 2;
//        else           rnum = 1;
        for(int i=0;i<num;i++) {
            rnum = rand.nextInt(10) + 1;
            //l.addNode();
            l.addNode(rnum);
            //l.addNode2(rnum);
//            rnum += 2;
        }
    }

    public static int sum(ListIterator lit) {
        int sum = lit.First();
        while(lit.NextNotNull()){
           sum += lit.Next();
        }
        return sum;
    }

    public static int max(ListIterator lit) {
        int mx = lit.First();
        int buf;
        while(lit.NextNotNull()) {
            buf = lit.Next();
            if(buf >= mx) mx = buf;
        }
        return mx;
    }

    public static int min(ListIterator lit) {
        int mn = lit.First();
        int buf;
        while(lit.NextNotNull()) {
            buf = lit.Next();
            if(buf <= mn) mn = buf;
        }
        return mn;
    }

    public static float mean(ListIterator lit) {
        int sum = lit.First();
        int count = 0;
        while(lit.NextNotNull()){
            sum += lit.Next();
            count++;
        }
        return sum/count;
    }

    public static void main(String[] args) {
        List a1 = new List(); //reference variable : a1 <- address
        //List a2 = new List();
        //MakeList(a1, 10); //10: number of Node
        //MakeList(a2,5);
        MakeList(a1, 8);
        a1.showList();
        System.out.println("################# Split Begin #################");
        int size = a1.GetCount();
        List [] al1 = new List[size];
        List [] al2 = a1.Split(al1);
        for(int i=0;i<size;i++) {
            if(al1[i] == null) continue;
            al1[i].showList();
        }
        List [] al3 = a1.Split(al2);
        for(int i=0;i<size;i++) {
            if(al3[i] == null) continue;
            al3[i].showList();
        }
        List [] al4 = a1.Split(al3);
        for(int i=0;i<size;i++) {
            if(al4[i] == null) continue;
            al4[i].showList();
        }
        List [] al5 = a1.Split(al4);
        for(int i=0;i<size;i++) {
            if(al5[i] == null) continue;
            al5[i].showList();
        }
        System.out.println("################# Mergesort Begin #################");
        List[] al6 = a1.mergesort(al5);
        for(int i=0;i<size;i++) {
            if(al6[i] == null) continue;
            al6[i].showList();
        }

        List[] al7 = a1.mergesort(al6);
        for(int i=0;i<size;i++) {
            if(al7[i] == null) continue;
            al7[i].showList();
        }

        List[] al8 = a1.mergesort(al7);
        for(int i=0;i<size;i++) {
            if(al8[i] == null) continue;
            al8[i].showList();
        }
        //System.out.println(num);

//        a2.showList();
//        System.out.println();

        //addList test
        //a1.addList(a2).showList();
//        List a3 = a1.addList(a2);
//        a3.showList();
//        System.out.println();
//        List a4 = new List(a1); //copy constructor
//        a4.showList();
//        System.out.println();

        //mergeList test;
//        List a4 = a1.mergeList(a2); //a1 is changed
//        a4.showList();
//        System.out.println();
//        List a5 = a2.mergeList(a1);
//        a5.showList();

        //mergesortList test
        //List a6 = a1.mergesortList(a2);
        //a6.showList();
//        List a7 = a2.mergesortList(a1);
//        a7.showList();

        //ListIterator
        //ListIterator al1 = new ListIterator(a6);
        //al1.showListIterator(); // --> current moving to last --> sum --> last value only
        //int result = sum(al1);
        //int result = max(al1);
        //int result = min(al1);
        //float result = mean(al1);
        //System.out.println(al1.First());
        //System.out.println("ListIterator sum : "+result);
        //System.out.println(al1.First());
        //copy constructor
//        List a5;
//        a5 = a4;
    }
}

