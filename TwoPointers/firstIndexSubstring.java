//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
//#2 pointer
//Be careful. Boundary conditions are blocking sbmission.


class Solution {
    public int strStr(String haystack, String needle) {
        //initializations
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        List <Integer> firstOccurence = new ArrayList();
        int h = 0, n = 0, f = 0, position = -1;
        
        if(needleLength > haystackLength)
            return -1;
        
        //pre-processing: storing all occurences of first letter in needle. So we know starting points for every iteration.
        while(h < haystackLength){
            if( haystack.charAt(h) == needle.charAt(0) )
                firstOccurence.add(h);
            h++;
        }
        
        h=0;
        while( f < firstOccurence.size() && h < haystackLength){
            h = n == 0 ? firstOccurence.get(f) : h;
            
            if(haystack.charAt(h) == needle.charAt(n) ){ //matching characters
                h++;
                n++; 
            }
            else{
                n=0;
                f++;   
            }
            if(n == needleLength){ //terminating condition
                position = firstOccurence.get(f);
                break;
            }
            
        }
        return position;
    }
}
