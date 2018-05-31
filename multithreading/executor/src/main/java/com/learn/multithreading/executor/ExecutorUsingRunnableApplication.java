package com.learn.multithreading.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorUsingRunnableApplication {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable job = () -> System.out.println("Thread: " + Thread.currentThread().getName() + " running in a thread using runnable interface.");

        //using this method we have no idea when the job is executed and we can  not wait for the job
        executorService.execute(job);


        Future<?> future = executorService.submit(job);

        //now we wait until the job finish execution.
        future.get();


    }
}
