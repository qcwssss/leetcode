public class removeCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0]- b[0]));
        int[] first = intervals[0];
        int res = N;
        for(int i = 1; i < N; i++) {
            if (first[0] <= intervals[i][0] &&
                first[1] >= intervals[i][1]) {
                res--;
            } else {
                // not covered
                first = intervals[i];
            }
        }
        return res;

    }
}
