package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4/discuss/49496/Another-accepted-Java-solution
 * Created by Helen on 3/3/2018.
 */
public class ReadNCharactersGivenRead4 extends Read4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        boolean eof = false;
        int total =0;
        while(!eof&&total<n){
            int count = read4(tmp);
            eof = count<4;
            count = Math.min(count,n-total);
            for(int i=0;i<count;i++){
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}
