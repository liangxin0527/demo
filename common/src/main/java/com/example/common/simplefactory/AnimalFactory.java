package com.example.common.simplefactory;

/**
 * @author liang
 * @date 2021/3/11
 */
public class AnimalFactory {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat("cat");
        Dog dog = new Dog();
        dog.eat("doag");
    }
}
