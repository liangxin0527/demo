package com.example.common.lbaic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liang
 * @date 2020/8/27
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,1, 2, 3, 4, 5, 6, 6, 7, 7, 7, 9, 100, 111);
        List<Integer> collect = list.stream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());
        collect.forEach(integer -> System.out.println(integer));
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,"add"+i);
        }
        ArrayList<Integer> key = new ArrayList<>();
        ArrayList<String> value= new ArrayList<>();
        map.forEach((integer, s) -> {
            key.add(integer);
            value.add(s);
        });
        List<String> add01 = value.stream().filter(s -> !s.contains("add1")).collect(Collectors.toList());
        add01.forEach(s -> System.out.println(s));
    }
}
