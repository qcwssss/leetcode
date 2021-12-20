public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        // sort
        Map<String, List> map = new HashMap<>();
        for (String elt : strs) {
            char[] arr = elt.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<String>());
            map.get(sorted).add(elt);
        }
        // collections to ArrayList
        return new ArrayList(map.values());
    }
}