public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < N; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[] {start, end});
                // add interval and update a new start
                start = intervals[i][0];
            }
            // always choose the larger value as the end
            end = Math.max(intervals[i][1], end);
        }
        res.add(new int[] {start, end});


        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
