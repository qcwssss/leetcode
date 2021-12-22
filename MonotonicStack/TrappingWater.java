public class TrappingWater {
    
    // O(n) time, O(n) space
    public int trap(int[] height) {
        int N = height.length;
        int[] maxLeft = new int[N], maxRight = new int[N];
        int[] minLR = new int[N];
        int res = 0;
        
        // DP
        maxLeft[0] = 0;
        for (int i = 1; i < N; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        
        maxRight[N - 1] = 0;
        for (int i = N - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }
        
        for (int i = 0; i < N; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
            res += Math.max(0, minLR[i] - height[i]);
        }
        
        return res;
        
    }
}