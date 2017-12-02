package edu.helen.leetcode;

/**
 * Created by Helen on 10/11/2017.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<3) return 0;
        boolean[] nonPrimes = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
            if(!nonPrimes[i]){
                count++;
                for(int j=2;i*j<n;j++){
                    nonPrimes[i*j]=true;
                }
            }
        }
        return count;
    }
}
