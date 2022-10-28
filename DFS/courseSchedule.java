//https://leetcode.com/problems/course-schedule/
//Detecting cycle in directed graph

class Solution {
    boolean [] visited1;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int p = prerequisites.length;
        int n = numCourses;
        int [][] graph = new int [n][n];
        
        //Create a graph
        for(int i=0; i<p; i++)
            graph[prerequisites[i][0]][prerequisites[i][1]] = 1;
        
        visited1 = new boolean[n];
        boolean [] visited2;
        for(int i=0; i<n; i++)
        {   
            if(visited1[i] == false) //no need to run DFS on every node as DFS on 1st node will recursively run DFS on other node. If graph is disconnected only then a new iteration will start
            {
                visited2 = new boolean[n];
                if(doesCycleExist(i, n, graph, visited2))
                    return false;
            }
        }
        return true;
    }
    
    public boolean doesCycleExist(int currentNode, int n, int[][] graph, boolean [] visited)
    {
        visited[currentNode] = true;
        if(visited1[currentNode] == true)
            return false;
        visited1[currentNode] = true;
        
        for(int i = 0; i<n; i++)
        {
            if(graph[currentNode][i] == 1 ) //i is an adjacent node
            {
                if( !visited[i] )
                {
                    if (doesCycleExist(i, n, graph, visited))
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
