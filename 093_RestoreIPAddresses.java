// Sourse : https://leetcode.com/problems/restore-ip-addresses/
// Date   : 2016-10-14

/***********************************************************************
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 **********************************************************************/

// 6ms

public class Solution {
    public List<String> restoreIpAddresses(String s) {
		List<String> ret = new ArrayList<>();
		
		StringBuffer ip = new StringBuffer();
		for(int a = 1 ; a < 4 ; ++ a)
		for(int b = 1 ; b < 4 ; ++ b)
	        for(int c = 1 ; c < 4 ; ++ c)
		for(int d = 1 ; d < 4 ; ++ d)
		{
			if(a + b + c + d == s.length() )
			{
				int n1 = Integer.parseInt(s.substring(0, a));
				int n2 = Integer.parseInt(s.substring(a, a+b));
				int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
				int n4 = Integer.parseInt(s.substring(a+b+c));
				if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
				{
					ip.append(n1).append('.').append(n2)
						.append('.').append(n3).append('.').append(n4);
					if(ip.length() == s.length() + 3) ret.add(ip.toString());
					ip.delete(0, ip.length());
				}
			}
		}
		return ret;
    }
}

// backtracking 12ms

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        backtracking(res, "", s, 0);
        return res;
    }
    private void backtracking(List<String> res, String temp, String s, int start) {
        String[] str = temp.split("\\.");
        if (str.length == 4 && start == s.length()) {
            res.add(temp);
            return ;
        }
        if (str.length < 4 && start < s.length()) {
            if (start != 0) temp = temp+".";
            for (int i = start+1; i <= s.length() && i <= start+3; i++) {
                String curr = s.substring(start, i);
                if (isValidIP(curr)) {
                    temp = temp + curr;
                    backtracking(res, temp, s, i);
                    temp = temp.substring(0, temp.length()-curr.length());
                }
            }
        }
    }
    private boolean isValidIP(String s) {
        int num = Integer.valueOf(s);
        if ((num > 0 && s.charAt(0) == '0') || (num == 0 && s.length() != 1)) {
            return false;
        }
        if (num >= 0 && num <= 255) {
            return true;
        }
        return false;
    }
}

