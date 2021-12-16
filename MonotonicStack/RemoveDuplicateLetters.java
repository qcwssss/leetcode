public class RemoveDuplicateLetters {



    public String removeDuplicateLetters2(String s) { // wrong
        char[] arr = s.toCharArray();
        // Arrays.asList() only works for reference types not primitive
        
        Set<Character> set = new HashSet<>();
        for (Character c : arr) set.add(c);
        char[] ans = new char[set.size()];
        int j = 0;
        for (char c : set) {
            ans[j] = c;
            j++;
        } 
        Arrays.sort(ans);
        String res = new String(ans);
        return res;
    }


class Solution {
    public String removeDuplicateLetters(String s) {

        // this is a fake stack, so we don't need to reverse.
        // Deque is a real stack
        // Deque<Character> stack = new Stack<>();
        Stack<Character> stack = new Stack<>(); 

        // this lets us keep track of what's in our solution/stack in O(1) time
        HashSet<Character> seen = new HashSet<>();

        // this will let us know if there are any more instances of s[i] left in s
        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i = 0; i < s.length(); i++) last_occurrence.put(s.charAt(i), i);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if (!seen.contains(c)){
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution optimal
                while(!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
    StringBuilder sb = new StringBuilder(stack.size());
    for (Character c : stack) sb.append(c.charValue());
    return sb.toString();
    }
}


class Solution {
    public String removeDuplicateLetters(String s) {
        // O(n) time, space
        char[] arr = s.toCharArray();
        Map<Character, Integer> lastIdx = new HashMap<>();
        Set<Character> stored = new HashSet<>(); // stored in stack

        Deque<Character> stack = new LinkedList<>();

        // build last index map
        for (int i = 0; i < arr.length; i++) {
            lastIdx.put(arr[i], i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (stored.contains(c)) continue;
            while (!stack.isEmpty() && c < stack.peek() && i < lastIdx.get(stack.peek())) {
                stored.remove(stack.pop());
            } 
            stack.push(c);   
            stored.add(c);
        }
        
        StringBuilder res = new StringBuilder();
        for (Character c : stack) res.append(c.charValue());
        return res.toString();
        
        
    }
}

}