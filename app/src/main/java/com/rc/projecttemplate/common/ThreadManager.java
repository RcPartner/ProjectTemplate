package com.rc.projecttemplate.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:线程管理类
 * 1）要新启一个线程执行任务的时候，不要直接使用new Thread 的方式，使用该类的线程池直接提交任务
 * Author: Caizemingg
 * Email:caizemingg@163.com
 * Date: 2016-09-18 15:42
 */
public class ThreadManager {

    // 最大线程数
    private static final int N_THREADS = 10;

    private static ExecutorService executorService;

    public static ExecutorService getInstance() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(N_THREADS);
        }
        return executorService;
    }
}
