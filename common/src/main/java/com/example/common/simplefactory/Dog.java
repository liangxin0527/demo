package com.example.common.simplefactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liang
 * @date 2021/3/11
 */
@Slf4j
public class Dog extends AbstartAnimal{

    @Override
    void eat(String string) {
        log.info("dog eat {}",string);
    }
}
