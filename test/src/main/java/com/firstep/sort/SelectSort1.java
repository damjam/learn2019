package com.firstep.sort;

/**
 * @author libaozhu
 * @date 2019/4/16 23:28
 */
public class SelectSort1 {
    public static void main(String[] args) {
        int[] a = {6,4,7,5,2,9,3};
        int[] b = sort(a);
        for(int item :b){
            System.out.print(item+" ");
        }
    }
    public static int[] sort(int[] array){

        for(int i=0; i<array.length; i++){
            int max = array[i];
            int k = i;
            for(int j=i+1; j<array.length; j++){
                if(array[j] > max){
                    max = array[j];
                    k = j;
                }
            }
            if(i != k){
                int tmp = array[i];
                array[k] = tmp;
                array[i] = max;
            }

        }
        return array;
    }
}
