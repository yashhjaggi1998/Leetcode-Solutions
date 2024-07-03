class Solution(object):
    def minimumAbsDifference(self, arr):

        arr.sort()
        
        diffTable = defaultdict(list)
        minDiff = float('inf')

        for indx in range(len(arr)-1):
            ele1, ele2 = arr[indx], arr[indx+1]
            
            diff = ele2 - ele1
            
            minDiff = min(minDiff, diff)
            diffTable[diff].append((ele1, ele2))

        return diffTable[minDiff]
