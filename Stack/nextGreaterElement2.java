//https://leetcode.com/problems/next-greater-element-ii/

/*
Reasoning:
To defeat circularity we observe that the maximum element in the array will always have -1. So we rearrange elements such that 
the elements to the right of max element are picked up as a block and moved to the left of the starting element. 

Eg: 12321 => 21123
Then we find next greater element corresponding to this new array and while filling result array adjust index corresponding to nums
array.
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] nums1 = new int[n];
        int top = 0;
        int div = 0;
        int [] stack = new int[n];
        int [] result = new int[n];
        
        //finding max element
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
                div = i;
            }
        }
        
        //creating a new array
        int k=0;
        int temp = div+1;
        while(temp < n){
            nums1[k] = nums[temp];
            k++;
            temp++;
        }
        
        for(int i=0; i<=div; i++){
            nums1[k] = nums[i];
            k++;
        }
        
        //finding next greater element in nums1
        result[div] = -1;
        stack[top] = nums1[n-1];
        
        for(int i=n-2; i>=0; i--)
        {
            int resultIndex = i < (n-div-1) ? i+div+1 : i-(n-div-1);
            while(top >= 0)
            {
                if(stack[top] > nums1[i]) //found next greater element
                {
                    result[resultIndex] = stack[top];
                    top++;
                    stack[top] = nums1[i];
                    break;
                }
                else
                    top--;
            }
            if(top == -1)
            {
                result[resultIndex] = -1;
                top++;
                stack[top] = nums1[i];
            }
        }
        return result;
    }
}
