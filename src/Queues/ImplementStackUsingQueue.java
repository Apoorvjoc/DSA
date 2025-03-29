package Queues;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * ImplementStackUsingQueue obj = new ImplementStackUsingQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class ImplementStackUsingQueue {

    Stack<Integer> st1 = new Stack();
    Stack<Integer> st2 = new Stack();

    public ImplementStackUsingQueue() {

    }

    public void push(int x) {
        st1.add(x);
    }

    public int pop() {
        //adding element to st2
        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }
        int ans = st2.pop();
        //adding element back to
        while(!st2.isEmpty()){
            st1.add(st2.pop());
        }
        return ans;
    }

    public int peek() {
        while(!st1.isEmpty()){
            st2.add(st1.pop());
        }
        int ans = st2.peek();
        //adding element back to
        while(!st2.isEmpty()){
            st1.add(st2.pop());
        }
        return ans;
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}
