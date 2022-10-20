//https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List <List<Integer>> pascalList = new ArrayList();
        List <Integer> rowList;
        
        if(numRows == 1)
        {
            rowList = new ArrayList();
            rowList.add(1);
            pascalList.add(rowList);
            return pascalList;
        }
        
        rowList = new ArrayList();
        rowList.add(1);
        pascalList.add(rowList);
        
        rowList = new ArrayList();
        rowList.add(1);
        rowList.add(1);
        pascalList.add(rowList);
        
        for(int i=2; i<numRows; i++)
        {
            rowList = new ArrayList();
            rowList.add(1);
            
            for(int j=1; j<i; j++)
            {
                int a = pascalList.get(i-1).get(j-1);
                int b = pascalList.get(i-1).get(j);
                rowList.add(a+b);
            }
            rowList.add(1);
            pascalList.add(rowList);
        }
        return pascalList;
    }
}
