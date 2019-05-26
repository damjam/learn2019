package com.firstep.sort;

/**
 * @author libaozhu
 * @date 2019/4/1 0:08
 */
public class TestString {
    public static void main(String[] args) {
        String s1 = "ab";
        String tmp1 = "a";
        String tmp2 = "b";
        String s3 = "a"+"b";
        String s2 = tmp1+tmp2;
        System.out.println(s1 ==s3);
    }
}
