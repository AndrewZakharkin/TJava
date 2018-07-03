package com.zakharkin.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Node {
    private List<Node> neighbours;
    private List<Integer> weights;
    private boolean isVisited;
    private int weight;
    private String name;

    {
        neighbours = new ArrayList<>();
        weights = new ArrayList<>();
    }

    public Node(String name){
        this.name = name;
    }

    public void addNodeWithWeight(Node node, int weight){
        neighbours.add(node);
        weights.add(weight);
    }

    public void addNodesWithWeights(Collection<Node> nodes, Collection<Integer> weights){
        neighbours.addAll(nodes);
        this.weights.addAll(weights);
    }

    public List<Node> getNeighbours() {
        return Collections.unmodifiableList(neighbours);
    }

    public List<Integer> getWeights() {
        return Collections.unmodifiableList(weights);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
}
