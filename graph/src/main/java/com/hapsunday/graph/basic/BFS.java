package com.hapsunday.graph.basic;

import java.util.ArrayList;
import java.util.List;

public class BFS {
    public List<Integer> Q;

    public BFS(DiGraph G, int... src) {
        Q = new ArrayList<>();
        boolean[] visited = new boolean[G.V()];

        for(int i=0; i<G.V(); ++i) {
            visited[i] = false;
        }
        for(int v: src) {
            Q.add(v);
            visited[v] = true;
        }

        for(int i=0; i<Q.size(); ++i) {
            int u = Q.get(i);
            for(int v: G.Adj(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    Q.add(v);
                }
            }
        }
    }
}
