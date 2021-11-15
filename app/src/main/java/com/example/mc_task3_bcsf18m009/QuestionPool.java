package com.example.mc_task3_BCSF18A511;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionPool {
    String [] catLists = {"Halqiyah","Lahatiyah","Shajariyah-Haafiyah","Tarfiyah","Nit-eeyah","Lisaveyah","Ghunna"};
    String [] s1 = {"ا", "ہ", "ع","ح","غ","خ"};
    String [] s2 = {"ق","ک"};
    String [] s3 = {"ج","ش","ی","ض"};
    String [] s4 = {"ل","ن","ر"};
    String [] s5 = {"ط","د","ت"};
    String [] s6 = {"ظ","ذ","ث"};
    String [] s7 = {"م","ن"};
    List<String[]> list;
    int [] indexArr = {0,1,2,3};
    public QuestionPool()
    {
        list = new ArrayList<String[]>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
    }

    public Question getRandomQuestion()
    {
        Random rand = new Random();
        int catIndex = rand.nextInt(7);
        String ans = catLists[catIndex];
        String [] temp = list.get(catIndex);
        String let = temp[rand.nextInt(temp.length)];
        List<String> optionList = new ArrayList<String>();
        optionList.add(ans);
        while(optionList.size()!=4)
        {
            catIndex = rand.nextInt(7);
            String s = catLists[catIndex];
            boolean flag = false;
            for(int i=0;i<optionList.size();i++)
            {
                if(optionList.get(i)==s)
                {
                    flag = true;
                }
            }
            if(flag==false)
            {
                optionList.add(s);
            }
        }
        shuffleIndexArray();
        Question q = new Question(let,optionList.get(indexArr[0]),optionList.get(indexArr[1]),optionList.get(indexArr[2]),optionList.get(indexArr[3]),ans);
        return q;
    }
    void shuffleIndexArray()
    {
        Random rand = new Random();
        for(int i =0;i<4;i++)
        {
            int index = rand.nextInt(4);
            int temp = indexArr[i];
            indexArr[i] = indexArr[index];
            indexArr[index] = temp;
        }
    }
}
