package org.hqf.tutorials.java;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectMapperThreadSafetyTest {

    private static final int THREAD_COUNT = 10; // Number of threads to use
    private static final int ITERATIONS = 1000; // Number of iterations per thread

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper(); // Shared ObjectMapper instance
        CountDownLatch startLatch = new CountDownLatch(1); // Start latch for threads
        AtomicInteger errorCount = new AtomicInteger(0); // Counter for errors

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    startLatch.await(); // Wait for start signal
                    for (int j = 0; j < ITERATIONS; j++) {
                        // Create a test object
                        TestObject object = new TestObject(finalI, j);

                        // Convert object to JSON string
                        String jsonString = mapper.writeValueAsString(object);

                        // Parse JSON string back to object
                        TestObject parsedObject = mapper.readValue(jsonString, TestObject.class);

                        // Verify that parsed object matches original object
                        if (!object.equals(parsedObject)) {
                            errorCount.incrementAndGet();
                            System.err.println("Error: Objects do not match: " + object + ", " + parsedObject);
                        }else {
                            System.out.println("Iteration " + j + " for thread " + finalI + " completed successfully");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        startLatch.countDown(); // Release start latch for threads
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        if (errorCount.get() > 0) {
            System.err.println("Error count: " + errorCount.get());
        } else {
            System.out.println("No errors detected");
        }
    }

}