// Sourse : https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
// Date   : 2016-11-25

/***********************************************************************
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, 
 * it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) 
 * that reads n characters from the file.
 * 
 * Note:
 * The read function may be called multiple times.
 *
 **********************************************************************/

// two buffer: internal buffer & external buffer

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {      // this question is about internal buffer and external buffer
    // internal buffer: i4, n4, buf4
    // external buffer: i, n, buf
        int i = 0;
        while (i < n) {     // external buf limitation
            if (i4 >= n4) {     // internal buf limitation
                i4 = 0;
                n4 = read4(buf4);
                if (n4 == 0) break;
            }
            buf[i++] = buf4[i4++];
        }
        return i;
    }
    char[] buf4 = new char[4];
    int i4 = 0, n4 = 0;
}