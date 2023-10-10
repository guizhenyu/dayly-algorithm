package com.gzy.algo.month202309;

import java.util.*;

public class September28Dijkstra {


    public static HashMap<Node, Integer> dijkstra(Node node){

        HashMap<Node, Integer> distanceMap = new HashMap<>();

        distanceMap.put(node, 0);
        HashSet<Node> selected = new HashSet<>();
        Node minNode = getMinDistanceAndUnSelectedNode(distanceMap, selected);

        while(minNode != null){
            int distance = distanceMap.get(minNode);

            List<Edge> edges = minNode.edges;
            for (Edge edge : edges){
                int w = edge.weight;

                Node to = edge.to;

                if (!distanceMap.containsKey(to)){
                    distanceMap.put(to, distance + w);
                }else {
                    distanceMap.put(to, Math.min(distanceMap.get(to), distance + w));
                }

            }
            selected.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(distanceMap, selected);


        }

        return distanceMap;
    }


    public static Node getMinDistanceAndUnSelectedNode(Map<Node, Integer> distanceMap, Set<Node> selectedMap){
        Node minNode = null;
        int min = Integer.MIN_VALUE;

        for (Node node : distanceMap.keySet()){
            Integer distance = distanceMap.get(node);

            if (!selectedMap.contains(node) && distance < min){

                minNode = node;
                min = distance;
            }

        }

        return minNode;
    }










    public class Node {

        public int value;

        public int in;

        public int out;

        public List<Node> nexts;

        public List<Edge> edges;


        public Node(int value){
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }

    }
    public class Edge {

        public int weight;

        public Node from;

        public Node to;

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

    }
}
