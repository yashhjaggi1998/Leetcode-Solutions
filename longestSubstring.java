//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//sliding window n2 solution.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int globalCount = 0;
        int n = s.length();
        
        for (int i=0; i<n; i++)
        {
            boolean[] visited = new boolean[1000];
            int uniqueCount = 0;
            
            for(int j=i; j<n; j++)
            {
                if( visited[s.charAt(j)] == true )
                {
                    
                    break;
                }
                else
                {
                    uniqueCount++;
                    visited[s.charAt(j)] = true;
                }
            }
            globalCount = uniqueCount > globalCount ? uniqueCount : globalCount;
        }
        return globalCount;
    }
}
