package com.firstep.simple;

/**
 * @author libaozhu
 * @date 2019/5/5 23:26
 */
public class GetOdd {
    public static void main(String[] args) {
        int a = -1;
        System.out.println(idOdd(a));
    }

    private static boolean idOdd(int a) {
        return (a & 1) == 1;
    }
}
