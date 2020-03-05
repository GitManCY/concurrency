package com.cy.create;

import java.util.Arrays;
import java.util.List;

public class Create08 {

    public int add(List<Integer> list){
        list.parallelStream().forEachOrdered(System.out::println);
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30);
        int res = new Create08().add(list);
        System.out.println("计算结果:"+res);
    }
}
