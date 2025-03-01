package com.dev;

import java.util.*;

public class Main {
    public int[] search(int[] nums , int target){
//        for(int i = 0; i<nums.length; i++){
//            for(int j = i+1; j<nums.length; j++){
//                if(nums[j] == target - nums[i]){
//                    return new int[] {i , j};
//                }
//            }
//        }
        Map<Integer, Integer> map = new HashMap<>();

//        for(int i = 0; i<nums.length; i++){
//            map.put(nums[i], i);
//        }
//        for(int i = 0; i<nums.length; i++){
//            int complement = target - nums[i];
//            if(map.containsKey(complement) && map.get(complement) != i){
//                return new int[] {i, map.get(complement)};
//            }
//        }

        for(int i = 0; i<nums.length; i++){

            int complement = target - nums[i];
            if(map.containsKey(complement)){

                return new int[] {map.get(complement), i};
            }
            map.put(nums[i],i );

        }
        return new int[] {};
    }

    public static void main(String args[]){

        Main hola = new Main();

        int numero[] = hola.search(new int[] {8,2,4,2,2}, 4);
        System.out.println(Arrays.toString(numero));

        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 0; c<=13; i++){

                i = c ;
                System.out.print(i + ", " );
                c = i + b;
                b = i;

                // 0  1 1 2 3 5
                //a=0     b=3    c=8  i=5
                //

        }
    }
}
