package com.ambity.alo.huisu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Question22 {
    public List<String> generateParenthesis(int n) {

        List<String> all = new ArrayList<>();
        if (n==0){
            return all;
        }
        addlist(all,"",0,0,n);

        return all;
    }
    public void addlist(List<String> all,String par,int leftSize,int rightSize,int n){
        if (rightSize>leftSize){
            return;
        }
        if (leftSize>n){
            return;
        }
        if (rightSize>n){
            return;
        }
        if (par.length()==2*n){
            all.add(par);
            return;
        }
        // 先放入左
        par = par + "(";
        leftSize = leftSize+1;
        addlist(all,par,leftSize,rightSize,n);
        // 回溯
        par = par.substring(0,par.length()-1);
        leftSize = leftSize-1;
        par = par + ")";
        addlist(all,par,leftSize,rightSize+1,n);
    }

    public static void main(String[] args) {
        Question22 question22 = new Question22();
        List<String> list =  question22.generateParenthesis(3);
        System.out.println(list.size());

    }
}
