public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        // merge intervals
        Map<Character, int[]> map = new HashMap<>(); // <char, {start, end}>
        // O(n) time
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new int[] {i, i});
            else {
                int[] interval = map.get(c);
                interval[1] = i;
                map.put(c, interval);
            }
        }
        ArrayList<int[]> intervals = new ArrayList<>(map.values()); 
        intervals.sort((a, b) -> (a[0] - b[0]));
        List<Integer> res = new ArrayList<>();
        
        int[] first = intervals.get(0);
        int start = first[0], end = first[1];
        
        for (int i = 1; i < intervals.size(); i++) {
            int[] cur = intervals.get(i);
                      
            // overlapping
            if (end >= cur[0]) end = Math.max(cur[1], end);
            else {
                res.add(end - start + 1);
                start = cur[0];
                end = cur[1];
            }            
        }
        res.add(end -start + 1);
        return res;    
        
    }
}