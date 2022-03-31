package com.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen on 2/23/2018.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
