public class NoOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // greedy
        int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int end = intervals[0][1];

        int res = 0;
        for (int i = 1; i < N; i++) {
            int[] cur = intervals[i];
            if (cur[0] >= end) { // no overlapping
                end = cur[1];
            } else {
                res++;
                // keep the end as last meeting's end, leave more space for the rest
            }
        }
        return res;

    }
}
