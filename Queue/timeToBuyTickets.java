//https://leetcode.com/problems/time-needed-to-buy-tickets/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0, n = tickets.length;
        int ptr = 0;
        
        while(tickets[k] > 0)
        {
            if(tickets[ptr] > 0)
            {
                tickets[ptr]--;
                time++;
                ptr++;
                ptr = ptr%n;
            }
            else
            {
                ptr++;
                ptr = ptr%n;
            }
        }
        
        return time;
    }
}
