public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int res = 0, left = 0;
        int[] count = new int[26];
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            count[c - 'A'] += 1;
            // if window is invalid for k replacements
            while ((i - left + 1) - findMax(count) > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A'] -= 1;
                left += 1;
            }
            res = Math.max(res, i - left + 1);
            
        }
        return res;
        
    }
    
    private int findMax(int[] count) {
        int max = Arrays.stream(count).max().getAsInt();
        // System.out.println("max=" + max);
        return max;
        
    }
}