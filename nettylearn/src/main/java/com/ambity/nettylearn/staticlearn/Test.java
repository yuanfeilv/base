package com.ambity.nettylearn.staticlearn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> a = new HashSet<>();
        a.add("11");
        a.add("22");
        Iterator<String> iterator = a.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
    }
}
