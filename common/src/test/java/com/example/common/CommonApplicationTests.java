package com.example.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@SpringBootTest
class CommonApplicationTests {

    @Test
    void contextLoads() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    }



}
