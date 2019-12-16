package com.hapsunday.algo.graph.basic;

public class TopologicalSort {
    public int[] rank;
    public int[] sorted;

    public boolean build(DiGraph G) {
        rank = new int[G.V()];
        sorted = new int[G.V()];
        int n = 0;
        int[] inDeg = new int[G.V()];
        for (int u = 0; u < G.V(); ++u) {
            rank[u] = -1;
            for (int v : G.Adj(u)) {
                inDeg[v]++;
            }
        }
        for (int i = 0; i < G.V(); ++i) {
            if (inDeg[i] == 0) {
                rank[i] = n;
                sorted[n++] = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            int u = sorted[i];
            for (int v : G.Adj(u)) {
                inDeg[v]--;
                if (inDeg[v] == 0) {
                    if (rank[v] >= 0) {
                        throw new RuntimeException("invalid state.");
                    }
                    if (rank[v] < 0) {
                        rank[v] = n;
                        sorted[n++] = v;
                    }
                }
            }
        }
        return n == G.V() && check(G);
    }

    boolean check(DiGraph G) {
        for(int u=0; u<G.V(); ++u) {
            for(int v: G.Adj(u)) {
                if (rank[u] >= rank[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}
