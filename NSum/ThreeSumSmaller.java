public class threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int N = nums.length;
        Arrays.sort(nums);
        // 3 sum -> 2 sum
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;
            // two pointers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) right--;
                else {
                  // add all optios smaller than target
                    res += right - left; 
                    left++;
                }
            }
        }
        return res;

    }
}
