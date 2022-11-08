//https://leetcode.com/problems/min-cost-climbing-stairs/
//#binary choice: space optimized

//Recursive relation: 2 choices either jump 1 index or 2 index and cost of that index. Recursion is forward and not backward.

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //initializations
        int n = cost.length;
        int [] dp = new int[n+1];
        int forward2 = 0, forward1 = 0;
        
        //base cases
        forward2 = 0;
        forward1 = cost[n-1];
        
        //iteration
        for(int i=n-2; i>=0; i--){
            int temp = Math.min(forward2, forward1) + cost[i];
            forward2 = forward1;
            forward1 = temp;
        }
        return Math.min(forward1, forward2);
        
    }
}
