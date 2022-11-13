//https://leetcode.com/problems/next-greater-element-i/

/*
Reasoning: 
We use stack to find next greater element in nums2 array.
Map stores these entries and then a single iteration over nums1 gives the result.
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int [] s = new int[n2]; 
        Map <Integer, Integer> m = new HashMap();
        int top = 0;
        
        m.put(nums2[n2-1], -1);
        s[top] = nums2[n2-1];
        
        for(int i=n2-2; i>=0; i--)
        {
            while(top > -1)
            {
                if(nums2[i] < s[top])
                {
                    m.put(nums2[i], s[top]);
                    top++;
                    s[top] = nums2[i];
                    break;
                }
                else
                    top--;   
            }
            if(top < 0)
            {
                m.put(nums2[i], -1);
                top++;
                s[top] = nums2[i];
            }        
        }
        
        int [] result = new int[n1];
        for(int i=0; i<n1; i++)
            result[i] = m.get(nums1[i]);
        
        return result;
    }
}
