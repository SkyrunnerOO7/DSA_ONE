
//GFG
//PROBLEM LINK : https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for(int count = 1; count < n; count++)
        {
            for(int j = 0; j<edges.length; j++)
            {
                int src = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];

                if(dist[src] != Integer.MAX_VALUE && dist[src]+weight < dist[dest])
                {
                    dist[dest] = dist[src] + weight;
                }
            }
        }

        for(int j = 0; j<edges.length; j++)
        {
            int src = edges[j][0];
            int dest = edges[j][1];
            int weight = edges[j][2];

            if(dist[src] != Integer.MAX_VALUE && dist[src]+weight < dist[dest])
            {
                return 1;
            }
        }

        return 0;
    }
}
