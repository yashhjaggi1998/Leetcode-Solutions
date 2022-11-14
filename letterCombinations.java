//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List <String> arr = new ArrayList();
        if( n == 0)
            return arr;
        
        HashMap <Character, List<Character>> m = new HashMap();
        m.put('2', Arrays.asList('a','b','c'));
        m.put('3', Arrays.asList('d','e','f'));
        m.put('4', Arrays.asList('g','h','i'));
        m.put('5', Arrays.asList('j','k','l'));
        m.put('6', Arrays.asList('m','n','o'));
        m.put('7', Arrays.asList('p','q','r','s'));
        m.put('8', Arrays.asList('t','u','v'));
        m.put('9', Arrays.asList('w','x','y','z'));
        
        int [] count = new int [5];
        for(int i=1; i<=n; i++)
            count[i] = m.get(digits.charAt(i-1)).size();
        
        String s1="", s2="", s3="", s4="";
        for(int i=count[1]; i>0; i--)
        {
            s1 = Character.toString( m.get(digits.charAt(0)).get(count[1]-i) );
            if( n == 1)
                arr.add(s1);
            for(int j=count[2]; j>0; j--)
            {
                s2 = s1 + Character.toString(m.get(digits.charAt(1)).get(count[2]-j));
                if( n == 2)
                    arr.add(s2);
                for(int k=count[3]; k>0; k--)
                {
                    s3 = s2 + Character.toString(m.get(digits.charAt(2)).get(count[3]-k));
                    if( n == 3)
                        arr.add(s3);
                    for(int l=count[4]; l>0; l--)
                    {
                        s4 = s3 + Character.toString(m.get(digits.charAt(3)).get(count[4]-l));
                        if( n == 4 )
                            arr.add(s4);
                    }
                        
                }
            } 
        }
        return arr;
    }
}
