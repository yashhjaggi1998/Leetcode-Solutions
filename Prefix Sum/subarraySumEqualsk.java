//https://leetcode.com/problems/subarray-sum-equals-k/
//Prefix Sum

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int finalAnswer = 0, prefixSum = 0;
        Map <Integer, Integer> m = new HashMap();
        
        m.put(0, 1);
        
        
        for(int i=0; i<n; i++)
        {
            prefixSum += nums[i];
            int diff = prefixSum - k;
            if( m.containsKey(diff) )
            {
                finalAnswer += m.get(diff);
            }
            if(m.containsKey(prefixSum))
                m.put( prefixSum, m.get(prefixSum)+1 );
            else
                m.put(prefixSum, 1);
        }  
        return finalAnswer;
    }
}
