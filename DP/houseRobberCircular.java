//https://leetcode.com/problems/house-robber-ii/
//Observation: Both first & last house cannot be together
//ans1 is without last house
//ans2 is without first house
//final answer is max(ans1, ans2)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if( n == 1)
            return nums[0];
        
        //1 .... n-1
        int prev2 = 0;
        int prev1 = nums[0];
        int curr, maxValue;
        for(int i=2; i<n ; i++)
        {
            curr = Math.max(prev2 + nums[i-1], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        maxValue = prev1;
        
        prev2 = 0;
        prev1 = nums[1];
        for(int i=2; i<n ; i++)
        {
            curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        
        maxValue = Math.max(maxValue, prev1);
        
        return maxValue;
    }
}
