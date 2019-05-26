package com.firstep.sort;


/**
 * @author libaozhu
 * @date 2019/5/1 22:57
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,0,8,6,4,2,2,2,1};
        quickSort(array, 0, array.length-1);
        for (int item : array) {
            System.out.println(array+" ");
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int mid = getDivide(array, left, right);
        if(mid>left){
            quickSort(array, left, mid);
        }
        if(mid+1<right){
            quickSort(array, mid+1, right);
        }
    }

    private static int getDivide(int[] array, int left, int right) {
        int base = array[left];
        int n = right;
        for(int i=right; i>left; i--){
            if(array[i] > base){
                n--;
                swap(array, i, n);
            }else {

            }

        }

        return n;
    }
    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
