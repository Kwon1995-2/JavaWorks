package com.tuyano.gradle3;
import java.util.*;
public class MyLotto {
    //복권발행
    public static Vector<Vector<Integer>> LottoPublish(Vector<Vector<Integer>> publish) {
        int n = 0; // 루프
        while(n<9) {
            Vector<Integer> e = new Vector<Integer>();
            e.add((int)(Math.random()*9)+1); //맨 앞
            for(int i=1;i<7;i++) e.add((int)(Math.random()*45)+1); //뒤에 더해짐
            publish.add(e);
            n++;
        }
        return publish;
    }
    //복권 출력
    public static void LottoPrint(Vector<Vector<Integer>> phone) {
        int n = 0;
        while(n < phone.size()) {
            Vector<Integer> temp = phone.get(n);
            System.out.print("조:"+temp.get(0)+"  Lotto:[");
            for(int i=1;i<temp.size()-1;i++)
                System.out.print(temp.get(i)+",");
            System.out.println(temp.get(6)+"]");
            n++;
        }
    }
    //한 사람당 구매한 복권 다 출력 -> 인자로는 전화번호 String이 들어감
    public static void buyPrint(Vector<Integer>[] people) {
        int n = 0;
        System.out.println("########## 구매한 복권 ##########");
        while(n<people.length) {
            Vector<Integer> temp = people[n];
            System.out.print("조:"+temp.get(0)+"  Lotto:[");
            for(int i=1;i<temp.size()-1;i++) {
                System.out.print(temp.get(i)+",");
            }
            System.out.println(temp.get(6)+"]");
            n++;
        }
    }
    //당첨 복권 출력
    public static void LottoWinPrint(Vector<Integer> win) {
        System.out.println("########## 당첨 복권 ##########");
        System.out.print("조:"+win.get(0)+"  Lotto:[");
        for(int i=1;i<win.size()-1;i++)
            System.out.print(win.get(i)+",");
        System.out.println(win.get(6)+"]");
    }
    //1등 당첨자 출력
    public static void WinnerPrint(HashMap<String, Vector<Integer>[]> person, Vector<Vector<Integer>> publish) {
            Set<String> phones = person.keySet();
            int rand = (int)(Math.random()*9) + 1;
            for(String phone : phones) { //loop 3번
                Vector<Integer> [] temp = person.get(phone);
                for(int i=0;i<temp.length;i++) {
                    if(temp[i] == publish.get(rand)) {
                        LottoWinPrint(temp[i]);
                        System.out.print("1등 전화번호:"+phone+"\n");
                        return;
                    }
                }
            }
    }

    public static void main(String[] args) {
        Vector<Vector<Integer>> publish = new Vector<Vector<Integer>>(); //복권 번호 담을 벡터
        LottoPublish(publish); // publish = LottoPublish(publish); --> 이렇게 안 해도 결과 잘 나옴
        LottoPrint(publish);
        HashMap<String, Vector<Integer>[]> person = new HashMap<>();
        //복권 구매
        person.put("000-111-1111",new Vector[]{publish.get(0), publish.get(1), publish.get(2)});
        person.put("000-222-2222",new Vector[]{publish.get(3), publish.get(4), publish.get(5)});
        person.put("000-333-3333",new Vector[]{publish.get(6), publish.get(7), publish.get(8)});
//        buyPrint(person.get("000-111-1111"));
//        buyPrint(person.get("000-222-2222"));
//        buyPrint(person.get("000-333-3333"));

        //복권 당첨
//        LottoWinPrint(publish.get((int)(Math.random()*9)+1));
        WinnerPrint(person, publish);

    }

}
