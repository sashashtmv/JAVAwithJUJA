package com.sashashtmv.week2.whiteCrow;
//make it work
public class WhiteCrow {

    public static int find(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            int a = nums[i];
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if(a == nums[j]){
                    found = true;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }
}
