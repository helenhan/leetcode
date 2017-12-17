package edu.helen.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://discuss.leetcode.com/topic/29303/two-end-bfs-in-java-31ms
 * http://bangbingsyb.blogspot.ca/2014/11/leetcode-word-ladder-i-ii.html
 * https://stomachache007.wordpress.com/2017/03/22/%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%E7%AC%94%E8%AE%B0-5-%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2-depth-first-search/#more-786
 * LeetCode中为数不多的考图的难题。尽管题目看上去像字符串匹配题，但从“shortest transformation sequence from start to end”还是能透露出一点图论中最短路径题的味道。如何转化？
 * <p>
 * 1. 将每个单词看成图的一个节点。
 * 2. 当单词s1改变一个字符可以变成存在于字典的单词s2时，则s1与s2之间有连接。
 * 3. 给定s1和s2，问题I转化成了求在图中从s1->s2的最短路径长度。而问题II转化为了求所有s1->s2的最短路径。
 * <p>
 * 无论是求最短路径长度还是求所有最短路径，都是用BFS。在BFS中有三个关键步骤需要实现:
 * <p>
 * 1. 如何找到与当前节点相邻的所有节点。
 * 这里可以有两个策略：
 * (1) 遍历整个字典，将其中每个单词与当前单词比较，判断是否只差一个字符。复杂度为：n*w，n为字典中的单词数量，w为单词长度。
 * (2) 遍历当前单词的每个字符x，将其改变成a~z中除x外的任意一个，形成一个新的单词，在字典中判断是否存在。复杂度为：26*w，w为单词长度。
 * 这里可以和面试官讨论两种策略的取舍。对于通常的英语单词来说，长度大多小于100，而字典中的单词数则往往是成千上万，所以策略2相对较优。
 * <p>
 * 2. 如何标记一个节点已经被访问过，以避免重复访问。
 * 可以将访问过的单词从字典中删除。
 * <p>
 * 3. 一旦BFS找到目标单词，如何backtracking找回路径？
 * Created by Helen on 12/8/2017.
 */
public class WordLadder {

    //BFS， two-end method
//traverse the path simultaneously from start node and end node, and merge in the middle
//the speed will increase (logN/2)^2 times compared with one-end method
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String > wordSet = new HashSet<>(wordList);
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0||!wordSet.contains(endWord)) {
            return 0;
        }
        int len = 1; // beginWord is the first one and not included in wordList.
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) { //Make the size of two sets close for optimization
                Set set = beginSet;//set1 is the forward set
                beginSet = endSet;//set2 provides the target node for set1 to search
                endSet = set;
            }
            Set<String> tmp = new HashSet<>();//intermediate Set
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) { //iterate the characters in string cur
                    for (char j = 'a'; j <= 'z'; j++) { //try all 26 alphabets
                        char old = chars[i];
                        chars[i] = j;

                        String target = new String(chars);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            tmp.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }

                }
            }
            beginSet = tmp;
            len++;
        }
        return 0;
    }
}
