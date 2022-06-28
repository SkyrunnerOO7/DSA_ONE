//LINKE OF QUESTION
// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1/
//PAIR CALSS FOR STORING VERTEX AND WEIGHT
    class Pair implements Comparable<Pair>{
        int wt;
        int v;
        
        Pair(int v, int wt)
        {
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Pair that)
        {
            return this.wt-that.wt;
        }
    }

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        boolean vis[] = new boolean[V];
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        q.add(new Pair(S, 0));
        
        int ans[] = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        ans[S] = 0;
        
        while(q.size() != 0)
        {
            Pair cur = q.remove();
            
            int u = cur.v;
            if(vis[u]){continue;}
            
            vis[u] = true;
            
            ArrayList<ArrayList<Integer>> neighbors = adj.get(u);
            
            for(ArrayList<Integer> list : neighbors)
            {
                int vertex = list.get(0);
                int wt = list.get(1);
                
                if(ans[vertex] > ans[u]+wt)
                {
                    ans[vertex] = ans[u]+wt;
                    q.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        
        return ans;
        
        
    }
}
