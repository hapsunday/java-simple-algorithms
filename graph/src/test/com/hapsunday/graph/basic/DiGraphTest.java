package com.hapsunday.graph.basic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class DiGraphTest {

    @Test
    public void addEdge() {
        DiGraph g = new DiGraph(10);
        for(int i=1; i<10; ++i) {
            g.addEdge(i-1, i);
        }
        Assert.assertEquals(g.V(), 10);
        Assert.assertEquals(g.Adj(0).size(), 1);
    }
}