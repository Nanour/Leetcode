// Sourse : https://leetcode.com/problems/simplify-path/
// Date   : 2016-11-07

/***********************************************************************
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 ***********************************************************************/

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String[] elems = path.split("/");
        for (String curr : elems) {
            switch(curr) {
                case ""  : break;
        		case "." : break;
        		case "..": if(!stk.isEmpty()) stk.pop();break;
        		default  : stk.push("/" + curr);
            }
        }
        if(stk.isEmpty()) {
            stk.push("/");
        }
    	StringBuffer sb = new StringBuffer();
    	while(!stk.isEmpty()) {
    	    sb.insert(0, stk.pop());
    	}
       	return sb.toString();
    }
}