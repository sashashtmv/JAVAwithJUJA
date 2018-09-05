package com.sashashtmv.week2.whiteCrow;
// make it fast
public class WhiteCrow3 {

    public static final int ERROR_COD = -1;
    public static int find(int[] nums) {
        int[] second = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            if(find(nums,second, i)){
                second[i] =1;
            }else return i;
        }
        return ERROR_COD;
    }

    private static boolean find(int[] arrays, int[] second, int givenNumberPosition) {
        int findNumber = arrays[givenNumberPosition];
        for (int index = 0; index < arrays.length; index++) {
            if (second[index] > 0 || givenNumberPosition == index) continue;
            if(findNumber == arrays[index]){
                return true;
            }
        }
        return false;
    }
}
