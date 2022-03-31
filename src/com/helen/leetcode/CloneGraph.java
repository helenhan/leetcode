package com.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/discuss/42309/Depth-First-Simple-Java-Solution?page=1
 * Created by Helen on 2/23/2018.
 */
public class CloneGraph {

    Map<Integer,UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label,cloned);
        for(UndirectedGraphNode neighbor:node.neighbors){
            cloned.neighbors.add(cloneGraph(neighbor));
        }
        return cloned;
    }
}
