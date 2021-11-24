class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = findMin(nums);
        int l = 0, r = nums.length - 1;

        // edge case: no rotate, r may eliminate target
        // so we need to choose end to compare
        if (target <= nums[r]) l = pivot;
        else r = pivot - 1;

        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        if (nums[l] == target) return l;
        else return -1;

    }
    // edge case
    int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid; // [4, 0, 2], mid = 1; if r = m - 1, we can't find pivot
        }
        return left;
    }

     // same approach
     public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (nums[m] > nums[r]) l = m + 1;
            else r = m;
        }
        int idx = l; // pivot index

        System.out.println("pivot="+idx);

        // search target part
        l = 0; r = nums.length - 1;
        if (target <= nums[nums.length - 1]) l = idx;
        else r = idx - 1;

        System.out.println("l="+l);
        System.out.println("r="+r);

        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;

            }
        }
        System.out.println("l="+l);

        if (nums[l] == target) return l;
        else return -1;

    }
}
