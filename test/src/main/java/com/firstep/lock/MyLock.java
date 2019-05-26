package com.firstep.lock;

import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author libaozhu
 * @date 2019/4/30 21:09
 */
public class MyLock implements Lock {

    AtomicReference<Thread> owner  = new AtomicReference<>();
    AtomicStampedReference<Thread> owner2 = new AtomicStampedReference<>(null, 0);
    public BlockingQueue<Thread> waiters = new LinkedBlockingDeque<>();
    @Override
    public void lock() {
        while (owner.compareAndSet(null, Thread.currentThread())){
            waiters.add(Thread.currentThread());
            LockSupport.park();

            waiters.remove(Thread.currentThread());
        }
    }
    @Override
    public void unlock() {
        //成功
        if(owner.compareAndSet(Thread.currentThread(), null)){
            //通知等待的线程
            Object[] objects = waiters.toArray();
            for(Object object: objects){
                Thread thread = (Thread)object;
                LockSupport.unpark(thread);
            }
        }
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
