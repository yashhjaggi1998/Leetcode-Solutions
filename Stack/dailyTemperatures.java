//https://leetcode.com/problems/daily-temperatures/
//using an array for stack instead of builtin java stack improved performance of the code both in terms of time and memory.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] s = new int[n];
        int [] result = new int[n];
        
        result[n-1] = 0;
        int top = 0;
        s[top] = n-1;
        
        for(int i=n-2; i>=0; i--){
            while(top > -1){
                if( temperatures[s[top]] > temperatures[i] ){
                    result[i] = s[top]-i;
                    top++;
                    s[top] = i;
                    break;
                }
                else
                    top--;
            }
            if(top < 0 ){
                result[i] = 0;
                top++;
                s[top] = i;
            }       
        }
        return result;
    }
}
