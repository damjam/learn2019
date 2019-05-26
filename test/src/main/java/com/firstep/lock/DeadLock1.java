package com.firstep.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author libaozhu
 * @date 2019/5/2 21:16
 */
public class DeadLock1 {
    public static void main(String[] args) {

        new Thread(new RunTread(true)).start();
        new Thread(new RunTread(false)).start();
    }
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();
    static class RunTread implements Runnable{
        private boolean flag;
        RunTread(boolean flag){
            this.flag = flag;
        }
        @Override
        public void run() {
            if(flag){
                try{
                    lock1.lock();
                    System.out.println("线程1执行第一步");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock1.unlock();
                }

                lock2.lock();
                System.out.println("");
                lock2.unlock();
            }else{
                try {
                    lock2.lock();
                    System.out.println("线程2执行");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock2.unlock();
                }
                lock1.lock();
                System.out.println("");
                lock1.unlock();
            }
        }
    }
}
