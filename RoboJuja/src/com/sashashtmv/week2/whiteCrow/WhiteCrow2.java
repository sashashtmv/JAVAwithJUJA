package com.sashashtmv.week2.whiteCrow;
// make it right
public class WhiteCrow2 {

    public static final int ERROR_COD = -1;

    public static int find(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if(!find(nums, i)){
                return i;
            }
        }
        return ERROR_COD;
    }

    private static boolean find(int[] arrays, int givenNumberPosition) {
        int findNumber = arrays[givenNumberPosition];
        for (int index = 0; index < arrays.length; index++) {
            if (givenNumberPosition == index) continue;
            if(findNumber == arrays[index]){
                return true;
            }
        }
        return false;
    }
}
