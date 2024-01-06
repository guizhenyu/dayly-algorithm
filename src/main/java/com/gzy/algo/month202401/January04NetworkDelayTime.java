package com.gzy.algo.month202401;

import java.util.*;

public class January04NetworkDelayTime {

    /**
     * You are given a network of n nodes, labeled from 1 to n. You are also given times,
     * a list of travel times as a directed edges times[i] = (ui, vi, wi), where ui is the source node,
     * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
     *
     * We will send a signal from a given node K. Return the minimum time it takes for all the n nodes to receive the signal.
     * If it is impossible for all the n nodes to receive the signal, return -1.
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k){
        // 使用Dijkstra算法去解
        if (times == null || times.length == 0){
            return -1;
        }

        Node[] nodes = new Node[n + 1];

        for(int i = 0; i < times.length; i++){
            int from = times[i][0];
            int to = times[i][1];
            int w = times[i][2];
            Node node = nodes[from];
            Node toNode = nodes[to];
            if (node == null){
                node = new Node(from);
                nodes[from] = node;
            }
            if (toNode == null){
                toNode = new Node(to);
                nodes[to] = toNode;
            }
            node.next.add(toNode);
            Edge edge = new Edge(node, toNode, w);
            node.edges.add(edge);
        }

        Map<Node, Integer>  distanceMap = new HashMap<>();
        Set<Node> selected = new HashSet<>();
        Node node = nodes[k];
        distanceMap.put(node, 0);
        Node minNode = getMinDistanceAndUnSelected(selected, distanceMap);

        while (minNode != null){
            int distance = distanceMap.get(minNode);

            List<Edge> edges = minNode.edges;

            for (Edge edge : edges){
                int w = edge.w;
                Node to = edge.to;
                if (!distanceMap.containsKey(to)){
                    distanceMap.put(to, distance + w);
                }else {
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + w));
                }
            }

            selected.add(minNode);
            minNode = getMinDistanceAndUnSelected(selected, distanceMap);
        }
        int ans = 0;
        for (int i = 1; i <= n; i++){
            Node key = nodes[i];
            if (!distanceMap.containsKey(key)){
                return -1;
            }

            Integer distance = distanceMap.get(key);

            ans = Math.max(ans, distance);
        }

        return ans;
    }

    public Node getMinDistanceAndUnSelected(Set<Node> selected, Map<Node, Integer>  distanceMap){
        Node minNode = null;
        Integer minD = Integer.MAX_VALUE;
        for (Node node : distanceMap.keySet()){
            Integer distance = distanceMap.get(node);
            if (!selected.contains(node) && minD > distance){
                minD = distance;
                minNode = node;
            }
        }
        return minNode;
    }

    public class Node {

        int value;

        List<Node> next;

        List<Edge> edges;

        public Node(int val){
            this.value = val;
            next = new ArrayList<>();
            edges = new ArrayList<>();
        }

    }


    public class Edge {

        Node from;

        Node to;

        int w;

        public Edge(Node from, Node to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

    }


    public static void main(String[] args) {
//        int[][] nums = {{1, 2, 1}};
//
//        January04NetworkDelayTime fc = new January04NetworkDelayTime();
//        int i = fc.networkDelayTime(nums, 2, 1);
//        System.out.println(i);


        System.out.println(-1l >>> -4);
    }
}
