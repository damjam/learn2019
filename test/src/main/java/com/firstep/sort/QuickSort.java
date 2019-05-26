package com.firstep.sort;

/**
 * @author libaozhu
 * @date 2019/4/18 22:19
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1,3,5,7,9,0,8,6,4,2,2,2,1};
        quickSort.sort(array, 0, array.length-1);
        for(int item:array){
            System.out.print(item+" ");
        }
    }
    public static int[] sort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            sort(array, start, smallIndex - 1);
        if (smallIndex < end)
            sort(array, smallIndex + 1, end);
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                //if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }
    public static int divide(int[] array, int start, int end) {
        if(array.length == 1){
            return 0;
        }
        int mid = start-1;
        int base = array[end];
        for(int i=start; i<=end-1; i++){
            if(array[i] <= base){
                mid ++;
                swap(array, mid, i);
            }
        }

        return mid;
    }
    /**
     * 交换数组内两个元素
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
