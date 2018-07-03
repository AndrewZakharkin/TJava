package com.zakharkin.Graph;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    /**
     * This will build nodes graph
     */
    public ImmutablePair<Node, List<Node>> BuildGraph(){
        List<Node> flatList = new ArrayList<>();
        //First Node

        Node root = new Node("root");
        flatList.add(root);

        //adding 2 neighbours
        Node rn1 = new Node("rn1");
        flatList.add(rn1);
        rn1.addNodeWithWeight(root, 5);//backward
        Node rn2 = new Node("rn2");
        flatList.add(rn2);
        rn2.addNodeWithWeight(root, 2);//backward
        root.addNodesWithWeights(List.of(rn1, rn2),  List.of(5, 2));

        Node rn1n1 = new Node("rn1n1");
        flatList.add(rn1n1);
        rn1.addNodeWithWeight(rn1n1, 3);
        rn1n1.addNodeWithWeight(rn1, 3);//backward

        Node rn2n1 = new Node("rn2n1");
        flatList.add(rn2n1);
        Node rn2n2 = new Node("rn2n2");
        flatList.add(rn2n2);

        rn2n1.addNodeWithWeight(rn2, 3);//backward
        rn2n2.addNodeWithWeight(rn2, 1);//backward
        rn2.addNodesWithWeights(List.of(rn2n1, rn2n2), List.of(3, 1));

        rn1n1.addNodeWithWeight(rn2n2, 1);
        rn2n2.addNodeWithWeight(rn1n1, 1);

        rn1n1.addNodeWithWeight(rn2n1, 1);
        rn2n1.addNodeWithWeight(rn1n1, 1);

        rn2n1.addNodeWithWeight(rn2n2, 2);
        rn2n2.addNodeWithWeight(rn2n1, 2);

        //print out neighbours count
        for(Node node : flatList){
            System.out.print(String.format("%s has %d neighbours: ", node.getName(),
                    node.getNeighbours().size()));
            int j = 0;
            for(Integer k : node.getWeights()){
                System.out.print(String.format("%s (%d) ", node.getNeighbours().get(j).getName(), k));
                ++j;
            }
            System.out.println();
            node.setWeight(Integer.MAX_VALUE);
        }
        flatList.get(0).setWeight(0);

        return new ImmutablePair<>(root, flatList);
    }
}
