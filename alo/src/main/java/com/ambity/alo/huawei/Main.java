package com.ambity.alo.huawei;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        String astring = String.valueOf(a);
        String[] temp = astring.split("\\.");
        int next = 0;
        if (temp[1].charAt(0) >= '5'){
            next = 1;
        }
        System.out.println(next + Integer.valueOf(temp[0]));
    }
}
