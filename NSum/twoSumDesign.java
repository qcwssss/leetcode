public class TwoSumDesign {
    List<Integer> list;
    Set<Integer> sum;

    // find O(1), add O(n), space O(n^2)
    public TwoSum() {
        list = new ArrayList<>();
        sum = new HashSet<>();
    }

    public void add(int number) {
        for (int i : list) {
            sum.add(number + i);
        }
        list.add(number);

    }

    public boolean find(int value) {
        return sum.contains(value);

    }

  class TwoSum {
    // find O(n), add O(1), O(n) space
    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>(); // <value, freq>

    }

    // O(1) time
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);

    }

    // O(n) time
    public boolean find(int value) {
        for (int key : map.keySet()) {
            int diff = value - key;
            // edge case: [0] -> false; [0, 0] -> true

            if (diff != key && map.containsKey(diff)) return true;
            if (diff == key && map.get(key) > 1) return true;
        }
        return false;
    }
}
