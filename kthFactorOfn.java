//https://leetcode.com/problems/the-kth-factor-of-n/
//#Math

class Solution {
    public int kthFactor(int n, int k) 
    {
        int kCopy = 0;
       for(int j=1; j<=n ; j++)
       {
            if(n%j == 0)
            {
                kCopy++;
                if(kCopy == k)
                    return j;
            }
       }
        return -1;
    }
}
