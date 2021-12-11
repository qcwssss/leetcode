public class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[] {b[0], b[2]}); // up
            height.add(new int[] {b[1], -b[2]}); // down
        }
        height.sort((a, b) -> a[0] == b[0] ? b[1] - a[1]: a[0] - b[0]); // go up first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // desc
        
        int preMax = 0;
        pq.offer(0);
        for (int[] h : height) {
            if (h[1] > 0) pq.offer(h[1]); // new house, add height to pq
            else pq.remove(-h[1]); // see old house, remove from pq height
            // pq.remove() takes O(n) time
            int curMax = pq.peek();
            if (preMax != curMax) {
                res.add(List.of(h[0], curMax));
                preMax = curMax;
            }
        }
        return res;
    }
}