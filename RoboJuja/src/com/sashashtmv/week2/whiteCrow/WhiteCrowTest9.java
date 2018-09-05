package com.sashashtmv.week2.whiteCrow;

import java.util.Date;
import java.util.Random;

public class WhiteCrowTest9 {
    public static void main(String[] args) {
        int[] nums = new int[10001];
        long current = new Date().getTime();
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = new Random().nextInt(100);

        }

        int expected = -1;
        int position = WhiteCrow2.find(nums);

        if(position == expected){
            System.out.println("Fail");
        }else {
            System.out.println(position);
            System.out.println("Ok");
        }
        System.out.println("Time in millseconds: " + (new Date().getTime() - current));
    }
}
