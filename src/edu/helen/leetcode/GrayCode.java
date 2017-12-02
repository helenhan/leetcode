package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen on 9/21/2017.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0;i<n;i++){
            int highest = 1<<i;
            for(int j=list.size()-1;j>=0;j--){
                int num = list.get(j);
                num+=highest;
                list.add(num);
            }
        }
        return list;
    }
}
