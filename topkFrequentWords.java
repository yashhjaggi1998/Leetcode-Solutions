//https://leetcode.com/problems/top-k-frequent-words/
//#Collections , Map, Sorting
import java.util.*;
import java.io.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map <String, Integer> map = new HashMap();
        
        for(int i=0; i<n; i++)
        {
            if( map.containsKey(words[i]) )
                map.put( words[i], map.get(words[i])+1 );
            else
                map.put( words[i], 1 );
        }
        Map <String, Integer> treemap = new TreeMap(map);
        List<String> returnList = sortByValue(treemap, k);
        
         return returnList;
        
    }
    
    public static List<String> sortByValue(Map<String, Integer> hm, int k)
    {
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
         
        List<String> temp = new ArrayList<String>();
        for (Map.Entry<String, Integer> aa : list) 
            temp.add(aa.getKey());
        
        List<String> returnList = new ArrayList<String>();
        for (int i=0; i<k; i++) 
            returnList.add(temp.get(i));
        
        
        
        return returnList;
    }
}
