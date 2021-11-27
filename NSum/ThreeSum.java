public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      int N = nums.length;
      // if (N == 0) return res;

      //3Sum -> 2 Sum
      Arrays.sort(nums);
      for (int i = 0; i < N -2; i++) { // i is cur, the 1st item of 3
          if(i != 0 && nums[i] == nums[i-1]) continue; //skip duplicate
        twoSum(res, nums, i+1, N - 1, nums[i]);
      }
      return res;
  }

  private void twoSum(List<List<Integer>> res, int[] nums, int l, int r, int cur) {
    // two pointers
    while(l < r) {
        int sum = nums[l] + nums[r] + cur;
        if (sum == 0){
            // update pointer if find result
            res.add(List.of(cur, nums[l++], nums[r--]));
            // remove duplicates
            while(nums[l] == nums[l-1] && l < r) l++;
            while(nums[r] == nums[r+1] && l < r) r--;
        }
        else if(sum < 0) l++;
        else r--;
    }
  }
}
