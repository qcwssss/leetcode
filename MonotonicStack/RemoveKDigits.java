public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && c - '0' < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c - '0');
        }
        
        // edge case, when k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isZero = true; // switch

        for (Integer i : stack) {
            // skip start with 0s
            if (i == 0 && isZero) continue;
            else isZero = false;

            sb.append(i.toString());
        }
        if (sb.length() == 0) return "0";
        else return sb.toString();
        
    }
}