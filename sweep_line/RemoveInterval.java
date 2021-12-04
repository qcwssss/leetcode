public class RemoveInterval {
      // my solution
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] cur : intervals) {
            // no overlap
            if (cur[1] <= toBeRemoved[0] || cur[0] >= toBeRemoved[1]) {
                res.add(List.of(cur[0], cur[1]));
            } else { // overlapping
                if (cur[0] < toBeRemoved[0] && cur[1] > toBeRemoved[1]) {
                    // cut middle
                    res.add(List.of(cur[0], toBeRemoved[0]));
                    res.add(List.of(toBeRemoved[1], cur[1]));
                } else if (cur[0] < toBeRemoved[0] && cur[1] <= toBeRemoved[1]) {
                    //cut right
                    res.add(List.of(cur[0], toBeRemoved[0]));
                } else {
                    // cut left
                    res.add(List.of(toBeRemoved[1], cur[1]));
                }

            }
        }
        return res;

    }

    // Eddie's better solution
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] cur : intervals) {
            // no overlap
            if (cur[1] <= toBeRemoved[0] || cur[0] >= toBeRemoved[1]) {
                res.add(List.of(cur[0], cur[1]));
            } else { // overlapping
                if (cur[0] < toBeRemoved[0]) {
                    // cut right
                    res.add(List.of(cur[0], toBeRemoved[0]));
                }
                if (cur[1] > toBeRemoved[1]){
                    // cut left
                    res.add(List.of(toBeRemoved[1], cur[1]));
                }
            }
          }
          return res;
      }

}
