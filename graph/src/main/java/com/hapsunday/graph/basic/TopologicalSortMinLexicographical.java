package com.hapsunday.graph.basic;

import java.util.PriorityQueue;


public class TopologicalSortMinLexicographical {
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
        PriorityQueue<Integer> Q = new PriorityQueue<>(G.V() + 2);

        for (int i = 0; i < G.V(); ++i) {
            if (inDeg[i] == 0) {
                Q.offer(i);
            }
        }

        while(!Q.isEmpty()) {
            int u = Q.poll();
            if (rank[u] >= 0) {
                throw new RuntimeException("invalid status.");
            }
            rank[u] = n;
            sorted[n++] = u;
            for(int v: G.Adj(u)) {
                inDeg[v]--;
                if (inDeg[v] == 0) {
                    if (rank[v] >= 0) {
                        throw new RuntimeException("invalid state.");
                    }
                    if (rank[v] < 0) {
                        Q.offer(v);
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
