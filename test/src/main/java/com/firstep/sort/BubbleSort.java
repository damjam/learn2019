package com.firstep.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author libaozhu
 * @date 2019/3/30 14:25
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,6,3,2,5,0,9,8,10,7,4};
        Integer[] newArray = new Integer[array.length];
        for(int k = array.length-1; k>=0; k--){
            boolean needSort = false;
            for(int i=0; i<k; i++){
                if(array[i] > array[i+1]){
                    int tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    needSort = true;
                }
            }
            if(!needSort){
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
