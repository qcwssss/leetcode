public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        //remaining freq map of target
        Map<Character, Integer> map = new HashMap<>(); 
        for (int i = 0; i < t.length(); i++) { 
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int validCount = 0;
        int minStart = 0, minSize = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) validCount++;
                map.put(cur, map.get(cur) - 1); // remaining 
            }

            // find target, try to shrink
            while (validCount == t.length()) {
                // update min window
                if (i - left + 1 < minSize) {
                    minSize = i - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    // remove leftChar from remaining map
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) validCount--;
                }
                left++;          
            }
        }
        if (minSize == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minSize);
        
    }
}