package com.firstep.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author libaozhu
 * @date 2019/4/30 23:30
 */
public class DeadLock {
    private static  Lock lock1 = new ReentrantLock();
    private static  Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunThread(true));
        Thread thread2 = new Thread(new RunThread(false));
        thread1.start();
        thread2.start();
    }
    static class RunThread implements Runnable{
        private boolean flag = false;
        public RunThread(boolean flag){
            this.flag = flag;
        }
        @Override
        public void run() {
            if(flag){
                lock1.lock();
                System.out.println("线程1获取lock1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lock();
                System.out.println("线程1获取lock2");
            }else {
                lock2.lock();
                System.out.println("线程2获取lock2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lock();
                System.out.println("线程2获取lock1");
            }
        }
    }

}
