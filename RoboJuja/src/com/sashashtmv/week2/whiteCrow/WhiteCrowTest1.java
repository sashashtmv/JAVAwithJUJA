package com.sashashtmv.week2.whiteCrow;

public class WhiteCrowTest1 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4};

        int expected = -1;
        int position = WhiteCrow.find(nums);

        if(position == expected){
            System.out.println("Fail");
        }else {
            System.out.println(position);
            System.out.println("OK");
        }
    }
}
