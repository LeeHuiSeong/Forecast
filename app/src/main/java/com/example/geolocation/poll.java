package com.example.geolocation;

import java.util.Hashtable;

public class poll {
    public static String question(int a) {
        Hashtable<Integer, String> A = new Hashtable<>();
        A.put(1,"추위를 많이 타시나요");
        A.put(2,"더위를 많이 타시나요??");
        A.put(3,"꽃가루 알레르기 혹은 알레르기성 비염 외 호흡기 질환을 가지고 계신가요?");
        A.put(4,"호흡기는 괜찮으신가요?");
        return(A.get(a));
    }
    public void result(int a){
        int Ans1 = 0;
        int Ans2 = 0;
        int Ans3 = 0;
        int Ans4 = 0;
        if(a == 1)
            Ans1 =+ 1;
        if(a == 2)
            Ans2 =+ 1;
        if(a == 3)
            Ans3 =+ 1;
        if(a == 4)
            Ans4 =+ 1;
    }

}
