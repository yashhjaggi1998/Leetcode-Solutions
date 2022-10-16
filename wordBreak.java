//https://leetcode.com/problems/word-break/
//#dynamic programming

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        String sub = "";
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i=1; i<=n; i++)
        {
            for(int j=0; j<i; j++)
            {
                sub = s.substring(j, i);
                if( dp[j] == true && wordDict.contains(sub) )
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
