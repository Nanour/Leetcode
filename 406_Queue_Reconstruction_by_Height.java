// Sourse : https://leetcode.com/problems/queue-reconstruction-by-height/
// Date   : 2016-11-23

/***********************************************************************
 *
 * Suppose you have a random list of people standing in a queue. Each person 
 * is described by a pair of integers (h, k), where h is the height of the 
 * person and k is the number of people in front of this person who have a 
 * height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 ***********************************************************************/

// Sort the array, tallest come first, if same height, lower k comes first
// Insert each element with k values.

// e.g.
// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
// after sort:
// [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
// insert, if current element is [6,1]
// [[7,0], [6,1], [7,1], [5,0], [5,2], [4,4]]
// insert, if current element is [5,0]
// [[5,0], [7,0], [6,1], [7,1], [5,2], [4,4]]
// ...

// sort: O(NlogN)

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]> () {
            @Override
            public int compare(int[] p1, int[] p2){
                return p1[0]==p2[0] ? p1[1]-p2[1] : p2[0]-p1[0];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int curr[] : res) {
            res.add(curr[1], people);
        }
        return res.toArray(new int[people.length][]);
    }
}