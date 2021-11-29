public class FourSum {
    // O(n^3) time
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;
        for (int i = 0; i < N - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < N - 2; j++) {
                if (j != i+1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = N - 1;

                // two pointers
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        // skip duplicates
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right] ) right--;
                    }
                    if (sum < target) left++;
                    else right--;
                }
            }
        }
        return res;

    }
}
