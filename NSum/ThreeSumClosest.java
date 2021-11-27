public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int res = nums[0] + nums[1] + nums[N-1];
        for (int i = 0; i < N - 2; i++) {
            // check duplicates
            // if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = N - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                // check
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                // move pointers
                else if (sum > target) right--;
                else left++;

            }
        }
        return res;

    }

    public static void main(String[] args) {
      ThreeSumClosest t = new ThreeSumClosest();
      int[] nums = new int[] {-1, 2, 1,-4, 1};
      t.threeSumClosest(nums, 1);
    }
}
