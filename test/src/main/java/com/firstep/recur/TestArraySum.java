package com.firstep.recur;

/**
 * @author libaozhu
 * @date 2019/4/8 0:46
 */
public class TestArraySum {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int result = sum(a, 0);
        System.out.println(result);
    }

    private static int sum(int[] a, int i) {
        if(i == a.length){
            return 0;
        }
        return a[i]+sum(a, i+1);
    }
}
