class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }
    private int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return find(parent[n]);
        // int root = find(parent[n]);
        // parent[n] = root;
        //return root;
    /*        
        int p = parent[n];
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p]; 
        }
        return p;
        */
    }
    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) return false;
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
