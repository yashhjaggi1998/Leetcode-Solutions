class Solution(object):
    def largestAltitude(self, gain):
        answer, currentAltitude = 0, 0

        for localGain in gain:
           currentAltitude += localGain
           answer = max(answer, currentAltitude)

        return answer
