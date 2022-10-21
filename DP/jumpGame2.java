//https://leetcode.com/problems/jump-game-ii/
//#Try to space optimize

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        
        //Initialization
        dp[n-1] = 0;
        
        //Main Logic
        for(int i=n-2; i>=0; i--)
        {
            int minValue = 10000;
            int k = Math.min( nums[i], n-1-i);
            for (int j = 1; j <= k ; j++)
            {      
                minValue = Math.min(dp[i+j]+1, minValue);
            }
            dp[i] = minValue;
        }
        return dp[0];
    }
}
