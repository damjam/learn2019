package com.firstep.algo;

import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        int x = 481;
        int[][] a = compute(x);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s2.append(x+"=");
        for(int i=0; i<a.length; i++){
            int[] b = a[i];
            s1.append("["+b[0]+","+b[1]+"]"+" ");
            s2.append((int)Math.pow(4, b[0])+"*"+(int)Math.pow(5, b[1])+"+");
        }
        System.out.println(s1.toString());
        System.out.println(s2.deleteCharAt(s2.length()-1).toString());
    }

    private static int[][] compute(int x){
        int maxLog4 = getMaxLog(4, x);
        int maxLog5 = getMaxLog(5, x);
        int[] array1 = new int[maxLog4+1];
        int[] array2 = new int[maxLog5+1];
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i=0; i<=maxLog4; i++){
            int value = (int)Math.pow(4, i);
            array1[i] = value;
            map1.put(value, i);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<=maxLog5; i++){
            array2[i] = (int)Math.pow(5, i);
            map2.put(array2[i], i);
        }
        List<Integer> list = new ArrayList<>();//所有可能出现的值组合
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array2.length; j++){
                int val = array1[i]*array2[j];
                if(val > x){
                    continue;
                }
                if(!list.contains(val)){
                    list.add(val);
                }
                map.put(val, map1.get(array1[i])+","+map2.get(array2[j]));
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        List<List<Integer>> all = new ArrayList<>();
        for(Integer from : list){
            List<Integer> targetList = new ArrayList<>();
            all.add(getCompose(x, from, targetList, list));
        }
        int n = Integer.MAX_VALUE;
        List<Integer> minPlan = null;
        for(List<Integer> plan : all){
            if(plan.size() < n){
                n = plan.size();
                minPlan = plan;
            }
        }
        int[][] result = new int[minPlan.size()][2];
        for(int i=0; i<minPlan.size(); i++){
            String[] tmpArray = map.get(minPlan.get(i)).split(",");
            int t1 = Integer.parseInt(tmpArray[0]);
            int t2 = Integer.parseInt(tmpArray[1]);
            result[i] = new int[]{t1, t2};
        }
        return result;
    }

    private static List<Integer> getCompose(int x, int from, List<Integer> targetList, List<Integer> list) {
        if(x == 0){
            return targetList;
        }
        for(Integer item: list){
            if(item>from || item > x){
                continue;
            }else {
                targetList.add(item);
                if(x == item){
                    return targetList;
                }else {
                    return getCompose(x-item, from, targetList, list);
                }
            }
        }
        return targetList;
    }

    private static int getMaxLog(int a, int b) {
        return (int)(Math.log((double)b)/Math.log((double)a));
    }
}
