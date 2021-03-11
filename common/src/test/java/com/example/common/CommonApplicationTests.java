package com.example.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class CommonApplicationTests {

    @Test
    void contextLoads() {
        ArrayList<Demo> strings = new ArrayList<>();
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
// 在short范围内足以让6MB的PermSize产生OOM了
        Integer i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }



}
