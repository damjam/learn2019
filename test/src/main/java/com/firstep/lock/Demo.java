package com.firstep.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author libaozhu
 * @date 2019/4/30 21:24
 */
public class Demo {
    static volatile int n=0;
    static final  Lock lock = new ReentrantLock();
    private void increase() {
        lock.lock();
        n++;
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        List<Thread> list = new ArrayList();
        for(int i=0; i<5; i++){
            Thread t  = new Thread(()->{
                for(int j=0; j<1000;j++){
                    demo.increase();
                }
            });
            t.start();
            //list.add(t);
        }

        for (Thread t: list){
            //t.join();
        }
        Thread.sleep(1000);
        System.out.println(n);
    }


}
