package org.hqf.tutorials.java;

import java.util.Objects;

public  class TestObject {
    private int threadId;
    private int iteration;

    public TestObject(int threadId, int iteration) {
        this.threadId = threadId;
        this.iteration = iteration;
    }

    public TestObject() {
    }

    public int getThreadId() {
        return threadId;
    }

    public int getIteration() {
        return iteration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestObject testObject = (TestObject) o;
        return threadId == testObject.threadId && iteration == testObject.iteration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(threadId, iteration);
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "threadId=" + threadId +
                ", iteration=" + iteration +
                '}';
    }
}
