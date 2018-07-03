package com.zakharkin.Graph;

import java.util.List;

public class Algo {
    private final Node rootNode;
    private final List<Node> flatList;

    public Algo(Node rootNode, List<Node> flatList){
        this.rootNode = rootNode;
        this.flatList = flatList;
    }

    public void runAlgo(Node currentNode){
        if(currentNode.isVisited())
            return;
        var neighbours = currentNode.getNeighbours();
        var weights = currentNode.getWeights();

        currentNode.setVisited(true);
        int baseWeight = currentNode.getWeight();

        for(int i = 0; i < neighbours.size(); ++i){

            int curWeight = neighbours.get(i).getWeight();
            if(curWeight > (baseWeight + weights.get(i))){
                curWeight = baseWeight + weights.get(i);
                neighbours.get(i).setVisited(false);
            }
            neighbours.get(i).setWeight(curWeight);
        }
        for(int i = 0; i < neighbours.size(); ++i){
            if(!neighbours.get(i).isVisited()){
                runAlgo(neighbours.get(i));
            }
        }
    }
}
