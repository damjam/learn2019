package com.firstep.sort;

/**
 * @author libaozhu
 * @date 2019/4/15 0:35
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1,5,6,3,9,4,2};
        int[] result = sort(array);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int[] sort(int[] array) {
        int[] result = new int[array.length];
        int tmp;
        int minIndex;
        for(int i=0; i<array.length; i++){
            minIndex = i;
            for(int j=i+1; j<array.length; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //if(minIndex > i){
                tmp = array[i];
                array[i] = array[minIndex];
            result[i]= array[minIndex];
                array[minIndex] = tmp;
            //}

        }
        return result;
    }


}
