package com.visa.prj.client;

import java.util.*;

public class ShortestPath {

    static class Edge {
        String destination;
        int weight;

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        String city;
        int distance;

        Node(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private Map<String, List<Edge>> graph = new HashMap<>();

    public void addEdge(String source, String destination, int weight) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());

        graph.get(source).add(new Edge(destination, weight));
        graph.get(destination).add(new Edge(source, weight)); // undirected
    }

    public void shortestPath(String start, String end) {

        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (String city : graph.keySet()) {
            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (current.distance > distance.get(current.city)) {
                continue; // Skip outdated entries
            }

            for (Edge edge : graph.get(current.city)) {

                int newDist = distance.get(current.city) + edge.weight;

                if (newDist < distance.get(edge.destination)) {
                    distance.put(edge.destination, newDist);
                    parent.put(edge.destination, current.city);
                    pq.add(new Node(edge.destination, newDist));
                }
            }
        }

        // Print shortest distance
        System.out.println("Shortest Distance: " + distance.get(end));

        // Reconstruct path
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println("Path: " + path);
    }

    public static void main(String[] args) {

         ShortestPath map = new ShortestPath();

        map.addEdge("Bangalore", "Chennai", 350);
        map.addEdge("Bangalore", "Hyderabad", 570);
        map.addEdge("Chennai", "Hyderabad", 630);
        map.addEdge("Hyderabad", "Mumbai", 710);
        map.addEdge("Chennai", "Mumbai", 1030);

        map.shortestPath("Bangalore", "Mumbai");
    }
}