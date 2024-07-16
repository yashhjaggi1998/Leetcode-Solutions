class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        
        n1, n2 = len(nums1), len(nums2)
        minHeap, answer, visited = [(nums1[0]+nums2[0], (0,0))], [], set((0,0))

        while True:
            selectedSum, (curr_i, curr_j) = heapq.heappop(minHeap)
            answer.append((nums1[curr_i], nums2[curr_j]))

            if len(answer) == k:
                break

            if curr_j+1 < n2 and (curr_i,curr_j+1) not in visited:
                heapq.heappush(minHeap, (nums1[curr_i]+nums2[curr_j+1], (curr_i, curr_j+1)))
                visited.add((curr_i, curr_j+1))

            if curr_i+1 < n1 and (curr_i+1,curr_j) not in visited:
                heapq.heappush(minHeap, (nums1[curr_i+1]+nums2[curr_j], (curr_i+1, curr_j)))
                visited.add((curr_i+1, curr_j))

        return answer
