//https://leetcode.com/problems/maximum-subarray/
//Space optimised but it also reduced time complexity

class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int prev = 0;
        int maxValue = Integer.MIN_VALUE;
        
        for(int i=1; i<=n; i++)
        {
            prev = Math.max( prev+nums[i-1], nums[i-1]); 
            if(maxValue < prev)
                maxValue = prev;
        }
        return maxValue;
    }
}
