package com.firstep.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author libaozhu
 * @date 2019/4/14 19:42
 */
public class Question153 {
    public Integer[] intersection(Integer[] a1, Integer[] a2){
        List<Integer> list2 = new ArrayList(Arrays.asList(a2));
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<a1.length; i++){
            for(int j=0; j<list2.size(); j++){
                if(a1[i] == list2.get(j)){
                    result.add(a1[i]);
                    list2.remove(j);
                    break;
                }
            }
        }
        return result.toArray(new Integer[result.size()]);
    }

    public static void main(String[] args) {
        Integer[] a1 = {1,2,2,1};
        Integer[] a2 = {2,2};
        Question153 question153 = new Question153();
        Integer[] a3 = question153.intersection(a1, a2);
        for(int i=0; i<a3.length; i++){
            System.out.print(a3[i]+",");
        }
    }
}
