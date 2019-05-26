package com.firstep.simple;

/**
 * @author libaozhu
 * @date 2019/4/27 22:38
 */
public class TestHashCode {
    public static void main(String[] args) {
        TestHashCode a1 = new TestHashCode();
        System.out.println(a1.hashCode());
        TestHashCode a2 = new TestHashCode();
        System.out.println(a2.hashCode());
    }
}
