class Solution(object):
    def plusOne(self, digits):
        carry, answer = 1, deque([])

        for i in range(len(digits)-1, -1, -1):
            digit = digits[i]
            _sum = digit + carry

            units = _sum % 10
            carry = _sum / 10

            answer.appendleft(units)

        if carry > 0:
            answer.appendleft(carry)

        return answer
        
