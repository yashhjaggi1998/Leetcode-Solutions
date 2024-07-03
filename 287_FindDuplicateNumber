''' 
  Idea is to use Binary search on range of numbers
  For each mid value if the elements in the array are greater than the range between left and mid then this range has the repeated number.
  Otherwise, the right half between mid & right have the repeated number.
'''
class Solution(object):
    def findDuplicate(self, nums):
        
        left = 1
        right = len(nums) - 1

        while left < right:

            mid = (left + right)/2

            eleCount = 0
            for num in nums:
                if num <= mid and num >= left:
                    eleCount += 1

            if eleCount > mid-left+1:
                right = mid
            else:
                left = mid + 1

        mid = (left + right)/2
        
        return mid
