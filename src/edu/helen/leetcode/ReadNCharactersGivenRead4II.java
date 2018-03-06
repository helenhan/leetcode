package edu.helen.leetcode;

/**
 * What is the difference between call once and call multiple times?
 *A: Think that you have 4 chars “a, b, c, d” in the file, and you want to call your function twice like this:

 read(buf, 1); // should return ‘a’
 read(buf, 3); // should return ‘b, c, d’
 All the 4 chars will be consumed in the first call. So the tricky part of this question is how can you preserve the remaining ‘b, c, d’ to the second call.

 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/discuss/49598/A-simple-Java-code
 * I used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls.
 * In the while loop, if buffPtr reaches current buffCnt, it will be set as zero to be ready to read new data.
 * Created by Helen on 3/3/2018.
 */
public class ReadNCharactersGivenRead4II extends Read4 {
    private char[] tmp = new char[4];
    private int pre = 0;
    private int cnt = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pre == 0) {
                cnt = read4(tmp);
            }
            if (cnt == 0) break;
            while (index < n && pre < cnt) {
                buf[index++] = tmp[pre++];
            }
            if (pre >= cnt) {
                pre = 0;
            }

        }
        return index;
    }
}
