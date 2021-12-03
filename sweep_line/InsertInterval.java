public class InsertIntervals {
    // O(n) time
    public int[][] insert(int[][] intervals, int[] newInterval) {
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
}
