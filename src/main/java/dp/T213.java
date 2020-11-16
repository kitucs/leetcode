package dp;

import java.util.Arrays;

public class T213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        int re =solution213.rob(new int[] {1,2,3,1});
        System.out.println(re);
    }
}
class Solution213 {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(robUntil(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                robUntil(Arrays.copyOfRange(nums, 1, nums.length)));


    }
    public int robUntil(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int[] dp = new int[nums.length+1];
        dp[0]=0;
        dp[1] = nums[0];
        dp[2] = nums[1];
        for (int i = 3; i < nums.length+1; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3])+nums[i-1];
        }
        return Math.max(dp[nums.length],dp[nums.length-1]);

    }
}