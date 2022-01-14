public class AtMostK {
    
 public int distinctSubarraysAtMostKOdd(int[] nums, int k) {
       int n = nums.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int odd = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 1) odd++;
                    
                if (odd > k) break;
                sb.append(nums[j]);
                set.add(sb.toString());
            }

        }
        return set.size();
    }
    
    
}

public class Main { 
    
    public static void main(String[] args) {
        test(new int[] {3, 2, 3, 2}, 1, 5);
        test(new int[] {3, 2, 3, 4}, 1, 7);
        test(new int[] {1, 3, 9, 5}, 2, 7);
        test(new int[] {2, 2, 5, 6, 9, 2, 11, 9, 2, 11, 12}, 1, 18);
    }
    
    private static void test(int[] nums, int k, int expected) {
        Solution sol = new Solution();
        int actual = sol.distinctSubarraysAtMostKOdd(nums, k);
        if (actual == expected) {
            System.out.println(actual);
        } else {
            throw new AssertionError(String.format("Expected %d, but actual %d", expected, actual));
        }
    }
}