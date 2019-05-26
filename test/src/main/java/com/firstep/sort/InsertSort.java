package com.firstep.sort;

/**
 * @author libaozhu
 * @date 2019/4/16 23:53
 * 插入排序实现思路：
 * 1、取当前遍历数字，索引为i
 * 2、找当前数字之前的数字并遍历，如果当前数字小于某个数，则退出循环，并标记当前数字索引为n
 * 3、将从n到i之间的数字全部后移
 * 4、将索引i的数字赋值给索引n
 */
public class InsertSort {
    public static void main(String[] args) {
        int [] a = {4,7,2,3,9,1,6,5,8};
        //由小到大
        for(int i=0; i<a.length-1; i++){
            int next = a[i+1];
            //当前元素和前面的比较
            int n = 0;
            boolean flag = false;
            for(int j=0; j<=i; j++){
                if(next < a[j]){
                    //把next放在j的位置，然后从j到i全部后移
                    n = j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                for(int k=i; k>=n; k--){
                    a[k+1] = a[k];//向后移动
                }
                a[n] = next;
            }
        }
        for(int item :a){
            System.out.print(item +" ");
        }
    }
}
