package com.smartyedu;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
    public static void main(String[] args) {
        //创建线程池
        //
        // Executors.newFixedThreadPool()       // 创建固定大小线程池
        // Executors.newSingleThreadExecutor()  // 创建单线程线程池
        // Executors.newCachedThreadPool()      // 创建缓存线程池
        // Executors.newScheduledThreadPool()   // 创建可延迟执行的线程池

        // 创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                16, 5, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        // 建议1. 如果任务为 cpu 运算型，核心线程适合设置为 cpu 核心数
        // 建议2. 如果任务为 io 型，推荐设置为 cpu 最大线程数
    }
}
