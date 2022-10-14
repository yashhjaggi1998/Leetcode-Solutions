//https://leetcode.com/problems/zigzag-conversion/

class Solution {
    public String convert(String s, int numRows) {
        int totalLetters = s.length();
        char[] arr = new char[totalLetters];
        int k = 0;
        
        for(int i=0 ; i<numRows ; i++)
        {
            int l = i;
            while(l < totalLetters && k < totalLetters)
            {
                arr[k] = s.charAt(l);
                k++;
                if(i != 0 && i != numRows-1 && l+(2*(numRows-1-i)) < totalLetters)
                {
                    arr[k] = s.charAt( l + (2*(numRows-1-i)) );
                    k++;
                }
                if(numRows == 1)
                    l++;
                else
                    l = l+2*numRows-2;
            }       
        }
        return new String(arr);
        
    }
    
}
