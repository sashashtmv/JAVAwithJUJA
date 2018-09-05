package com.sashashtmv.week2.whiteCrow;

public class WhiteCrowTest5 {
    public static void main(String[] args) {
        int[] nums = {};

        int expected = -1;
        int position = WhiteCrow.find(nums);

        if(position == expected){
            System.out.println("Fail");
        }else {
            System.out.println(position);
            System.out.println("Ok");
        }
    }
}
