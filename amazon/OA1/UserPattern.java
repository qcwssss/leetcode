public class UserPattern {
    class Pair {
        int time;
        String web;
        
        public Pair(int time, String web) {
            this.time = time;
            this.web = web;
        }
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        int n = website.length;
        for (int i = 0; i < n; i++) {
            String user = username[i];
            map.putIfAbsent(user, new ArrayList<>());
            map.get(user).add(new Pair(timestamp[i], website[i]));
        }
        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String key : map.keySet()) {
            Set<String> set = new HashSet<>();
            List<Pair> list = map.get(key);
            Collections.sort(list, (a, b) -> (a.time - b.time)); // ??
            int m = list.size();
            for (int i = 0; i < m; i++) {
                for (int j = i + 1; j < m; j++) {                    
                    for (int k = j + 1; k < m; k++){
                        // if (j == i || k == i || k == j) continue;
                        String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if (!set.contains(str)) {
                            set.add(str);
                            count.put(str, count.getOrDefault(str, 0) + 1);
                        }
            
                        if (res.equals("")|| count.get(res) < count.get(str) || 
                            count.get(res) == count.get(str) && res.compareTo(str) > 0) {
                            res = str;
                        }
                    }
                }
            }
        }
        return Arrays.asList(res.split(" "));               
        
    }
}