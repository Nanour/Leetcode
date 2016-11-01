// Sourse : https://leetcode.com/problems/min-stack/
// Date   : 2016-10-27

/***********************************************************************
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 **********************************************************************/


// 如果是min，则push两次，pop时如果peek的值为当前min，pop出当前值后更新min

public class MinStack {
    Stack<Integer> stk;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stk = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            stk.push(min);
            min = x;
        }
        stk.push(x);
    }
    
    public void pop() {
        if (stk.peek() == min) {
            stk.pop();
            min = stk.pop();
        } else {
            stk.pop();  
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */