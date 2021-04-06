package com.example.common.builder;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CarBuilder {

    private Car car = new Car();

    public CarBuilder addName(String name) {
        car.setName(name);
        return this;
    }

    public CarBuilder addSeat(String seat) {
        car.setSeat(seat);
        return this;
    }

    public CarBuilder addScreen(String screen) {
        car.setScreen(screen);
        return this;
    }

    public CarBuilder addLogo(String logo) {
        car.setLogo(logo);
        return this;
    }

    public CarBuilder addTires(String tires) {
        car.setTires(tires);
        return this;
    }

    public Car build() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        return car;
    }
}
