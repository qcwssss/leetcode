public class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
        

    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
        
    }
    
    public void push(int x) {
        // remember max state for each value
        int max = maxStack.isEmpty() ? x : maxStack.peek(); 
        maxStack.push( x > max ? x : max);
        stack.push(x);
     
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new LinkedList<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop(); // pop both stack and maxStack
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;

    }
    

}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */