package com.example.mc_task3_BCSF18A511;

public class Question {
    String  letter;
    String op1;
    String op2;
    String op3;
    String op4;
    String correctOption;
    public Question(String l, String o1, String o2, String o3, String o4, String ans)
    {
        letter = l;
        op1 = o1;
        op2 = o2;
        op3 = o3;
        op4 = o4;
        correctOption = ans;
    }
}
