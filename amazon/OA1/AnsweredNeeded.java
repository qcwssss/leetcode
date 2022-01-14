public class AnsweredNeed {
    public static int answeredNeed(List<Integer> answered, List<Integer> needed, int q) {
        int n = answered.length;
        List<Integer> rest = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            rest.add(needed.get(i) - answered.get(i));
        }

        int res = 0;
        Collections.sort(rest);
        for (int r : rest) {
            if (r == 0) {
                res++;
            } 
            else if (r > 0) {
                if (q - r >= 0) {
                    res++;
                    q -= r;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}