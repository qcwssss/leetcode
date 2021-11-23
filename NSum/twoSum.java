class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] dummy = nums.clone();

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); // <value, index>
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }


        return res;
    }
}
