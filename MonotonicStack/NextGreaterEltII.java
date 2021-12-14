public class nextGreaterEltI {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        
        int[] res = new int[N];

        // monotonic stack
        // pretend we add a copy to the end of array
        for (int i = 2*N - 1; i >= 0; i--) {
            int cur = nums[i%N];
            // maintain desc of stack, from bottom to top 
            while (!stack.isEmpty() && cur >= stack.peek()) stack.pop();
            res[i%N] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(cur);
        }
        

        return res;
    }
}