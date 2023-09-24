package Week6.Synchronization.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeArrayList<E> {
    private final List<E> LIST = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addElement(E str) {
        lock.lock();
        try {
            LIST.add(str);
        } finally {
            lock.unlock();
        }
    }

    public void removeElement(E str) {
        lock.lock();
        try {
            LIST.remove(str);
        } finally {
            lock.unlock();
        }
    }

    public void printSize(String flavorText) {
        lock.lock();
        try {
            System.out.println(flavorText + LIST.size());
        } finally {
            lock.unlock();
        }
    }
}
