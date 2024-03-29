package com.helen.leetcode;

/**
 * Created by Helen on 3/4/2018.
 */
public class FindCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i=0;i<n;i++){
            if(knows(candidate,i)){
                candidate = i;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=candidate&& (knows(candidate,i)||!knows(i,candidate))){
                return -1;
            }
        }
        return candidate;
    }

    boolean knows(int a, int b){
        return true;
    }
}
