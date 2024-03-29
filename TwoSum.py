#Optimzation2: use hash table to store the key as 'diff of target and element' and value as the index of the element.
class Solution(object):
    def twoSum(self, nums, target):
        diffDict = {}

        for i in range(0, len(nums)):
            number = nums[i]
            diff = target - number
            if number in diffDict:
                return [diffDict[number], i]
            else:
                diffDict[diff] = i
