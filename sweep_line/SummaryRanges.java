//352. Data Stream as Disjoint Intervals
// Hard

public class SummaryRanges {
    TreeSet<int[]> set;
    

    public SummaryRanges() {
        set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }
    
    public void addNum(int val) {
        int[] interval = new int[] {val, val};
        if (set.contains(interval)) return;

        int[] low = set.lower(interval), high = set.higher(interval);
        if (high != null && high[0] == val) return;

        // insert right in the middle of two slot
        if (low != null && low[1] + 1 == val && 
            high != null && high[0] - 1 == val) {
                low[1] = high[1];
                set.remove(high);
            }
        // merge left time slot    
        else if (low != null && low[1] + 1 >= val) low[1] = Math.max(low[1], val);
        // merge right slot
        else if (high != null && high[0] - 1 <= val) high[0] = Math.min(high[0], val);
        else set.add(interval);
    }
    
    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for (int[] i : set) {
            res.add(i);
        }
        return res.toArray(new int[0][]);
        
    }
}