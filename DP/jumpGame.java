//https://leetcode.com/problems/jump-game/
//#cannot space optimize as it requires multiple choices at each ith position

//Recursive Relation: opt(i): max Value or return true if we can reach from ith position to n-1th position. 

class Solution {
    public boolean canJump(int[] nums) {
        //initializations
        int n = nums.length;
        boolean [] dp = new boolean[n];
        
        //base case
        dp[n-1] = true;
        
        //iteration
        for(int i=n-2; i>=0; i--)
        {
            boolean maxValue = false;
            for(int j=1; j <= Math.min(n-1-i, nums[i]); j++)
            {
                maxValue = maxValue || dp[i+j];
            }
            dp[i] = maxValue;
        }
        
        //return final value
        return dp[0];
    }
}
