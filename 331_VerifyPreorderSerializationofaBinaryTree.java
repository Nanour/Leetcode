// Sourse : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
// Date   : 2016-11-07

/***********************************************************************
 *
 * One way to serialize a binary tree is to use pre-order traversal. When we 
 * encounter a non-null node, we record the node's value. If it is a null node, 
 * we record using a sentinel value such as #.
 * 
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
 * where # represents a null node.
 * 
 * Given a string of comma separated values, verify whether it is a correct preorder traversal 
 * serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * 
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 ***********************************************************************/

// stack
// 如果是数字push
// 如果是‘#’
//     stk.peek() 也是 '#', pop ‘#‘ 和数字 直到再次peek不是’#‘， 最后push '#'
//     stk.peek() 不是 '#', push
// 最后如果size == 1 并且 peek == ‘#’ 则为true，反之为false

public class Solution {
    public boolean isValidSerialization(String preorder) {
         if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}

// 计算出度和入度
// https://discuss.leetcode.com/topic/35976/7-lines-easy-java-solution/2

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}



