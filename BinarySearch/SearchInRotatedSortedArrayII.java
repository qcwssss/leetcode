//81. Search in Rotated Sorted Array II
class Solution {
    public boolean search(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) { // check the last mid
        int mid = l + (r - l)/2;
        if (target == nums[mid]) return true;

        // right part is sorted
        else if (nums[l] > nums[mid]) {
          // target in the left
          if (target < nums[mid] || target > nums[r]) {
            r = mid - 1;
          } else {
            l = mid + 1;
          }
        }
        // left part is sorted
        else if (nums[l] < nums[mid]) {
          //  target in the right part
          if (target > nums[mid] || target < nums[l]) {
            l = mid + 1;
          } else {
            r = mid - 1;
          }
        } else {
          // duplicates
          // nums[l] == nums[mid]
          l++;

        }
      }
      return false;

    }

    public static void main(String[] args) {

       Solution s = new Solution();
      int[] arr = new int[] {1,0,1,1,1,0};
      s.search(arr, 0);
    }
  }
