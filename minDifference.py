class Solution(object):
    def minDifference(self, nums):
        
        '''
            Base Case:
            if length is less than 5 
            then any 1,2,3 can be replaced with the 3rd value
        '''
        if len(nums) <= 4: 
            return 0

        nums.sort()

        diff1 = nums[-4] - nums[0] # if 1st smallest element is minimum then max will be 4th largest
        diff2 = nums[-3] - nums[1] # if 2nd smallest element is minimum then 1 swap is for smallest and 2 for 2 largest. Thus, max element will be 3rd largest
        diff3 = nums[-2] - nums[2] # if 3rd smallest element is minimum then 2 swaps for 1st 2 smallest and 1 for largest. Thus, max element will be 2rd largest
        diff4 = nums[-1] - nums[3] # if 4th smallest element is minimum then 3 swaps for 1st 3 smallest. Thus, max element will be largest

        return min(diff1, diff2, diff3, diff4)
