//https://leetcode.com/problems/roman-to-integer/

import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int num = 0;
        Hashtable<Character, Integer> romans = new Hashtable<>();
        
        romans.put('I',1);
        romans.put('V',5);
        romans.put('X',10);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('D',500);
        romans.put('M',1000);
        
        for(int i=0; i<s.length(); i++)
        {
            int e1 = romans.get( s.charAt(i) );
            int e2 = i+1 < s.length() ? romans.get( s.charAt(i+1) ) : 0;
            if(e2 > e1)
            {
                num += e2-e1;
                i++;
            }
            else
                num += e1;
        }
        return num;
    }
}
