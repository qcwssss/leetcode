public class InsertIntervals {
    // O(n) time
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        int start = newInterval[0], end = newInterval[1]; //insert
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int first = intervals[i][0], last = intervals[i][1]; // current interval
            if (end < first || start > last) {
                // no overlapping
                res.add(new int[]{first, last});
                if (start != newInterval[0] || end != newInterval[1]) {
                            res.add(new int[]{start, end});

                }
            } else {
                // overlapping
                start = Math.min(start, first);
                end = Math.max(end, last);
            }

        }
                res.add(new int[]{start, end});

        return res.toArray(new int[0][]); // check : list.toArray(T[] a) source code

    }

    // better approach
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] cur : intervals) {
            if ( newInterval == null || newInterval[0] > cur[1]) {
                // or already added
                // too early, no overlapping
                res.add(cur);
            } else if (newInterval[1] < cur[0]) {
                // already pass newInterval, and no overlap
                res.add(newInterval);
                res.add(cur);
                newInterval = null; // added

            } else {
                //overlapping
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }

        }
        if (newInterval != null) res.add(newInterval);

        return res.toArray(new int[0][]);

    }
}
