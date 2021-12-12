public class nextGreaterEltI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1= nums1.length, n2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(); // <value, greater>
        
        // monotonic stack
        Stack<Integer> stack = new Stack<>(); 
        for (int i = 0; i < n2; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur > stack.peek()) {
                map.put(stack.pop(), cur);
            }
            stack.push(cur);

        }
        
        // add rest
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            res[i] = map.get(nums1[i]);
        }
        
        return res;
    }
}