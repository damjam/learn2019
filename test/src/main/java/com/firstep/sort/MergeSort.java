package com.firstep.sort;

/**
 * @author libaozhu
 * @date 2019/4/6 20:13
 */
public class MergeSort {
    //归并排序
    public static void main(String[] args) {

        int [] a = {4,7,2,3,9,1,6,5,8};
        int[] result = mergeInside(a, 0, a.length-1);
        for(int item:result){
            System.out.println(item+" ");
        }
    }

    private static int[] mergeInside(int[] a, int left, int right) {
        if(left>=right){
            return null;
        }
        int mid = left+(right-left)/2;
        mergeInside(a, left, mid);
        mergeInside(a, mid+1, right);
        return merge(a, left, mid, right);
    }

    private static int[] merge(int[] a, int left, int mid, int right) {
        int[] result = new int[right-left+1];
        int i= left;
        int j = mid+1;
        int k = left;
        while (i<left && j<right){
            if(a[i] < a[j]){
                result[k] = a[i];
                i++;
            }else{
                result[i] = a[j];
                j++;
            }
            k++;
        }

        while (j<=right && k<=right){
            result[k] = a[j];
            j++;
            k++;
        }
        while (i<=mid && k<=a.length){
            result[k] = a[i];
            i++;
            k++;
        }

        return result;
    }
}
