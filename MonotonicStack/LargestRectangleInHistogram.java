public class LargestRectangleArea {
    
    // brute force, O(n^2) time
    public int largestRectangleArea_1(int[] heights) {
        int maxArea = 0;
        int N = heights.length;
        for (int i = 0; i < N; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < N; j++) {
                minHeight = Math.min(heights[j], minHeight);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
            
        }
        return maxArea;
    }

    // O(n) time 
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // index
        int N = heights.length;
        int maxArea = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        // stack is not empty
        while (!stack.isEmpty()) {
            int popIdx = stack.pop();
            int height = heights[popIdx];
            int width = N - (stack.isEmpty() ? 0 : stack.peek() + 1);
            maxArea = Math.max(maxArea, height * width);
            
        }
        return maxArea;
    
    
    }
}