package com.company.random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {
    private int v;
    private int weight;
    Node(int v, int w) {
        this.v = v;
        this.weight = w;
    }
    Node() {}
    public int getV() {
        return this.v;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.weight < o2.weight) {
            return -1;
        }
        if(o1.weight > o2.weight) {
            return 1;
        }
        return 0;
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Node>());
        }

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));
        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));
        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));
        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));
        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));
        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));
        shortestPath(0, adj, n);
    }

    private static void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int n) {
        int[] dist = new int[n];
        for(int i=0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node> (n, new Node());
        pq.add(new Node(s, 0));
        while (pq.size() > 0) {
            Node node = pq.poll();
            for(Node itNode : adj.get(node.getV())) {
                if(dist[node.getV()] + itNode.getWeight() < dist[itNode.getV()]) {
                    dist[itNode.getV()] = dist[node.getV()] + itNode.getWeight();
                    pq.add(new Node(itNode.getV(), dist[itNode.getV()]));
                }
            }
        }
        System.out.println("The Distances from Source " + s + " are : ");
        for(int i=0; i<n; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
