//https://leetcode.com/problems/sort-colors/
//Logic: sore count of each element: 0,1,2
//for each item say 0, use replacePointer to point to index which needs to be swapped with next 0.

class Solution {
    public void sortColors(int[] nums) {
        //initializations
        int n = nums.length;
        int [] count = new int[3];
        int pointer = 0, replacePointer = 0;
        
        //pre-processing
        for(int i=0; i<n; i++)
            count[nums[i]]++;
        
        //swapping logic
        while(count[0] > 0){
            if(nums[pointer] == 0){
                int temp = nums[replacePointer];
                nums[replacePointer] = nums[pointer];
                nums[pointer] = temp;
                replacePointer++;
                count[0]--;
            }
            pointer++; 
        }
        
        pointer = 0;
        while(count[1] > 0){
            if(nums[pointer] == 1){
                int temp = nums[replacePointer];
                nums[replacePointer] = nums[pointer];
                nums[pointer] = temp;
                replacePointer++;
                count[1]--;
            }
            pointer++; 
        }
    }
}
