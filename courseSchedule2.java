//https://leetcode.com/problems/course-schedule-ii/

class Solution {
    int [][] graph;
    boolean [] globalVisited;
    int [] indegree;
    int [] outdegree;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int p = prerequisites.length;
        int n = numCourses;
        boolean [] visited; 
        
        //Creating a graph
        graph = new int[n][n];
        indegree = new int[n];
        outdegree = new int[n];
        for(int i=0; i<p; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from][to] = 1;
            outdegree[from]++;
            indegree[to]++;
        }
        
        //Detecting if cycle exists
        globalVisited = new boolean[n];
        for(int i=0; i<n; i++){
            
            if(globalVisited[i] == false)
            {
                visited = new boolean [n];
                if( isCycle(i, n, visited) )
                {
                    return new int[0];
                }               
            }
        }
        
        //If acyclic then find topological sorting.
        Queue <Integer> indegreeNodes = new LinkedList();
        int [] courseOrdering = new int [n];
        
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
                indegreeNodes.add(i);
        }
        int k=0;
        while(indegreeNodes.size() > 0)
        {
            int from = indegreeNodes.poll();
            courseOrdering[k] = from;
            k++;
            //for all out edges remove them 
            for(int to=0; to<n; to++)
            {
                if( graph[from][to] == 1 )
                {
                    graph[from][to] = 0;
                    indegree[to]--;
                    if(indegree[to] == 0)
                        indegreeNodes.add(to);
                }
            }
        }
        
        return courseOrdering;
        
    }
    
    public boolean isCycle(int currentNode, int n, boolean [] visited)
    {
        visited[currentNode] = true;
        if( globalVisited[currentNode] )
            return false;
        globalVisited[currentNode] = true;
        
        for(int i=0; i<n; i++){
            if( graph[currentNode][i] == 1 ) //for adjacent nodes
            {
                if(visited[i] == false)
                {
                    if(isCycle(i, n, visited))
                        return true;
                    else
                        visited[i] = false;
                }
                else if(visited[i] )
                    return true;
            }
        }
        return false;
    }
}
