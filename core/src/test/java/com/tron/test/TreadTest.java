package com.tron.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadTest {

    public  void testTest() {
        //任务
        TestRun testRun = new TestRun();

        //线程数量，并发访问的线程数量
        int n = 0;

        //总调用次数
        int count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        for (int i = 0; i < count; i++) {
            executorService.submit(testRun);
        }

    }

    public static class TestRun implements Runnable{

        @Override
        public void run() {
            //要执行的任务
        }
    }
}
