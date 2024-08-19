package com.TwentySevenFour.back.algorithm;

import java.util.*;

public class AlgorithmDefinition {
    public static class Node {
        public String name;
        public double distance;

        public Node(String name, double distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static class NodeComparator implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            return Double.compare(n1.distance, n2.distance);
        }
    }

    public static PathResult dijkstra(Map<String, Map<String, Double>> graph, String source, String target) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        for (String node : graph.keySet()) {
            distances.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }
        distances.put(source, 0.0);
        pq.add(new Node(source, 0.0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            String currentNode = current.name;

            if (current.distance > distances.getOrDefault(currentNode, Double.MAX_VALUE)) {
                continue;
            }

            if (graph.containsKey(currentNode)) {
                for (Map.Entry<String, Double> neighborEntry : graph.get(currentNode).entrySet()) {
                    String neighbor = neighborEntry.getKey();
                    double weight = neighborEntry.getValue();
                    double newDist = distances.get(currentNode) + weight;

                    if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                        distances.put(neighbor, newDist);
                        previous.put(neighbor, currentNode);
                        pq.add(new Node(neighbor, newDist));
                    }
                }
            }
        }

        List<String> path = new ArrayList<>();
        String step = target;
        if (previous.containsKey(step)) {
            while (step != null) {
                path.add(step);
                step = previous.get(step);
            }
            Collections.reverse(path);
        }

        double distanceToTarget = distances.getOrDefault(target, Double.MAX_VALUE);
        return new PathResult(distanceToTarget, path);
    }

    public static void addEdge(Map<String, Map<String, Double>> graph, String start, String end, double distance) {
        graph.putIfAbsent(start, new HashMap<>());
        graph.putIfAbsent(end, new HashMap<>());
        graph.get(start).put(end, distance);
        graph.get(end).put(start, distance); // Bidirectional edge
    }

    public static class PathResult {
        public double distance;
        public List<String> path;

        public PathResult(double distance, List<String> path) {
            this.distance = distance;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Distance: " + distance + ", Path: " + String.join(" -> ", path);
        }
    }
}