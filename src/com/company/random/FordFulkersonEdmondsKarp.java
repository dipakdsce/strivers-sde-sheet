package com.company.random;

import java.util.*;

public class FordFulkersonEdmondsKarp {
    public static void main(String[] args) {
        int[][] capacity = {{0, 3, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 0},
                {3, 0, 0, 1, 2, 0, 0},
                {0, 0, 0, 0, 2, 6, 0},
                {0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 9},
                {0, 0, 0, 0, 0, 0, 0}};
//        System.out.println(maxFlow(capacity, 0, 6));

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<>();
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(1);
        edge1.add(2);
        edge1.add(8);
        Edges.add(edge1);
        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(3);
        edge2.add(10);
        Edges.add(edge2);
        ArrayList<Integer> edge3 = new ArrayList<>();
        edge3.add(4);
        edge3.add(2);
        edge3.add(2);
        Edges.add(edge3);
        ArrayList<Integer> edge4 = new ArrayList<>();
        edge4.add(3);
        edge4.add(4);
        edge4.add(3);
        Edges.add(edge4);
        System.out.println(findMaxFlow(4, 4, Edges));
    }

    private static boolean bfs(int[][] residualCapacity, HashMap<Integer, Integer> parent, int source, int sink) {
        int n = residualCapacity.length;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(source);
        visited.add(source);
        boolean foundAugmentedPath = false;
        //See if we can find augmented path from source to sink
        while(!bfsQueue.isEmpty()) {
            int u = bfsQueue.poll();
            for(int v = 0; v < n; v++) {
                //explore the vertex only if not visited, and its residual capacity is grater than 0
                if(!visited.contains(v) && residualCapacity[u][v] > 0) {
                    //add in parent map saying v got explored by u
                    parent.put(v, u);
                    //add v to visited
                    visited.add(v);
                    //add v to queue for BFS
                    bfsQueue.add(v);
                    //if sink is found then augmented path is found
                    if(v ==  sink) {
                        foundAugmentedPath = true;
                        break;
                    }
                }
            }
        }
        //return if augmented path from source to sink is found or not
        return foundAugmentedPath;
    }

    public static int maxFlow(int[][] capacity, int source, int sink) {
        int n = capacity.length;
        int m = capacity[0].length;

        //Declare and initialize residual capacity as total available capacity initially.
        int[][] residualCapacity = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                residualCapacity[i][j] = capacity[i][j];
            }
        }

        //This is parent map for storing BFS parent
        HashMap<Integer, Integer> parent = new HashMap<>();

        //stores all the augmented paths
        List<List<Integer>> augmentedPaths = new ArrayList<>();

        //Stored max flow we can get in this network
        int maxFlow = 0;
        while (bfs(residualCapacity, parent, source, sink)) {
            List<Integer> augmentedPath = new ArrayList<>();
            int flow = Integer.MAX_VALUE;
            //find minimum flow in augmented path and also add vertices in the augmented path
            int v = sink;
            while(v != source) {
                augmentedPath.add(v);
                int u = parent.get(v);
                flow = Math.min(flow, residualCapacity[u][v]);
                v = u;
            }
            augmentedPath.add(source);
            Collections.reverse(augmentedPath);
            augmentedPaths.add(augmentedPath);
            maxFlow += flow;

            //Decrease residual capacity by floe from u to v in augmentedPath
            //and Increase residual capacity by flow from v to u
            v = sink;
            while (v != source) {
                int u = parent.get(v);
                residualCapacity[u][v] -= flow;
                residualCapacity[v][u] += flow;
                v = u;
            }
        }
        return maxFlow;
    }

    private static boolean bfsList(HashMap<Integer, List<HashMap<Integer, Integer>>> residualCapacity, HashMap<Integer, Integer> parent, int source, int sink) {
        boolean foundAugmentPath = false;
        Queue<Integer> bfsQueue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        bfsQueue.add(source);
        visited.add(source);
        while (!bfsQueue.isEmpty()) {
            int u = bfsQueue.poll();
            List<HashMap<Integer, Integer>> edgeList = residualCapacity.get(u);
            if(edgeList != null && edgeList.size() > 0) {
                for(HashMap<Integer, Integer> capacityMap : edgeList) {
                    for(Map.Entry<Integer, Integer> entry : capacityMap.entrySet()) {
                        int v = entry.getKey();
                        if(!visited.contains(v)) {
                            parent.put(v, u);
                            visited.add(v);
                            bfsQueue.add(v);
                            if(v == sink) {
                                foundAugmentPath = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return foundAugmentPath;
    }

    private static int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        HashMap<Integer, List<HashMap<Integer, Integer>>> residualCapacity = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        for(int i=0; i<M; i++) {
            int u = Edges.get(i).get(0);
            List<HashMap<Integer, Integer>> edgeList;
            HashMap<Integer, Integer> capacityMap = new HashMap<>();
            if(residualCapacity.containsKey(u)) {
                edgeList = residualCapacity.get(u);
            } else {
                edgeList = new ArrayList<>();
            }
            int capacity = Edges.get(i).get(2);
            capacityMap.put(Edges.get(i).get(1), capacity);
            edgeList.add(capacityMap);
            residualCapacity.put(u, edgeList);

            capacityMap = new HashMap<>();
            int v = Edges.get(i).get(1);
            if(residualCapacity.containsKey(v)) {
                edgeList = residualCapacity.get(v);
            } else {
                edgeList = new ArrayList<>();
            }
            capacityMap.put(u, capacity);
            edgeList.add(capacityMap);
            residualCapacity.put(v, edgeList);
        }
        int maxFlow = 0;
        while (bfsList(residualCapacity, parent, 1, N)) {
            int flow = Integer.MAX_VALUE;
            int v = N;
            while (v != 1) {
                int u = parent.get(v);
                List<HashMap<Integer, Integer>> edgeList = residualCapacity.get(u);
                for (Map<Integer, Integer> capacityMap : edgeList) {
                    if (capacityMap.containsKey(v)) {
                        flow = Math.min(flow, capacityMap.get(v));
                        break;
                    }
                }
                v = u;
            }
            maxFlow += flow;
            v = N;
            while(v != 1) {
                int u = parent.get(v);
                List<HashMap<Integer, Integer>> edgeList =  residualCapacity.get(u);
                for(Map<Integer, Integer> capacityMap :  edgeList) {
                    if(capacityMap.containsKey(v)) {
                        int capacity = capacityMap.get(v);
                        if(capacity - flow == 0) {
                            capacityMap.remove(v);
                        } else {
                            capacityMap.put(v, capacity - flow);
                        }
                        break;
                    }
                }
                v = u;
            }
        }
        return maxFlow;
    }
}
