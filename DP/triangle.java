//https://leetcode.com/problems/triangle/
//#2D array

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n+1][n+1];
        
        //Initialization
        dp[0][0] = 0;
        for(int k=1; k<=n; k++)
        {
            dp[k][k] = dp[k-1][k-1] + triangle.get(k-1).get(k-1);
            dp[k][0] = dp[k-1][0] + triangle.get(k-1).get(0);
        }
        
        //Main Logic
        for(int i=2; i<=n; i++)
            for(int j=1; j<i; j++)
                dp[i][j] = triangle.get(i-1).get(j-1) + Math.min(dp[i-1][j-1], dp[i-1][j]);
        
        //Final Answer
        int minValue = Integer.MAX_VALUE;
        for(int k=0; k<=n ; k++)
            minValue = Math.min(dp[n][k], minValue);
        
        return minValue;
    }
}
