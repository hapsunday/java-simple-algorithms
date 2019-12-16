package com.hapsunday.graph.basic;

import java.util.LinkedList;
import java.util.List;


public class DiGraph {
    private int numV;
    LinkedList<Integer>[] adj;

    public DiGraph(int V) {
        this.numV = V;
        this.adj = new LinkedList[V];
        for(int i=0; i<numV; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public int V() {
        return numV;
    }

    public List<Integer> Adj(int v) {
        return adj[v];
    }

    public DiGraph getTransposeGraph() {
        DiGraph g = new DiGraph(numV);
        for(int u=0; u<V(); ++u) {
            for(int v: Adj(u)) {
                g.addEdge(v, u);
            }
        }
        return g;
    }
}
