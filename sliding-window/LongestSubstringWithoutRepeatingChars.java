public class LongestSubtringWithoutRepeatingChars {
    
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            char cur = s.charAt(i);
            while(set.contains(cur)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(cur);
            res = Math.max(res, i - left + 1);             
            
        }
        return res;
    }
}