//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
//#Queue

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int count = n;
        int t=0, h=0;
        int residualCount0 = 0, residualCount1 = 0;
        
        while(t<n)
        {
            if (students[h] == 1) 
                residualCount1++;
            else if (students[h] == 0)
                residualCount0++;
            
            if( students[h] == sandwiches[t] )
            {
                t++;
                if (students[h] == 1) 
                    residualCount1--;
                else if (students[h] == 0)
                    residualCount0--;
                students[h] = -1;
                h++;
                count--;
            }
            else
                h++;
            
            if (h == n)
            {
                //No students left that want type 0 sandwich but stack on top has sandwich type 1
                if ( residualCount0 == 0 && sandwiches[t] == 0) 
                   break; 
                if ( residualCount1 == 0 && sandwiches[t] == 1) 
                   break; 
                //students of both type want sandwiches so we continue the process
                else 
                {
                    residualCount0 = 0;
                    residualCount1 = 0;
                    h = 0;
                }
            }
        }
        
        return count;
    }
}
