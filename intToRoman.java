//https://leetcode.com/problems/integer-to-roman/
//#Solve using hashtable

class Solution {
    public String intToRoman(int num) {
        String one = "";
        
        for(int i=3; i>=0; i--)
        {
            int q = num / ((int)Math.pow(10,i));
            num = num % ((int)Math.pow(10,i));
            if(i == 3)
            {
                while( q > 0 )
                {
                    one = one + "M";
                    q--;
                }
            }
            else if(i == 2)
            {
                if(q == 4)
                    one = one + "CD";
                else if(q == 9)
                    one = one + "CM";
                else if(q == 5)
                    one = one + "D";
                else
                {
                    if(q/5 < 1)
                    {
                        while(q > 0)
                        {
                            one = one + "C";
                            q--;
                        }
                    }
                    else
                    {
                        q = q%5;
                        one = one + "D";
                        while(q > 0)
                        {
                            one = one + "C";
                            q--;
                        }
                    }
                }
            }
            else if(i == 1)
            {
                if(q == 4)
                    one = one + "XL";
                else if(q == 9)
                    one = one + "XC";
                else if(q == 5)
                    one = one + "L";
                else
                {
                    if(q/5 < 1)
                    {
                        while(q > 0)
                        {
                            one = one + "X";
                            q--;
                        }
                    }
                    else
                    {
                        q = q%5;
                        one = one + "L";
                        while(q > 0)
                        {
                            one = one + "X";
                            q--;
                        }
                    }
                }
            }
            else
            {
                if(q == 4)
                    one = one + "IV";
                else if(q == 9)
                    one = one + "IX";
                else if(q == 5)
                    one = one + "V";
                else
                {
                    if(q/5 < 1)
                    {
                        while(q > 0)
                        {
                            one = one + "I";
                            q--;
                        }
                    }
                    else
                    {
                        q = q%5;
                        one = one + "V";
                        while(q > 0)
                        {
                            one = one + "I";
                            q--;
                        }
                    }
                }
            }
        }
        return one;
    }
}
