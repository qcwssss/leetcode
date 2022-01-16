import java.util.*;

public class Keypad {
    public static int minPress(String a) {
        Map<Character, Integer> map = new HashMap<>(); // <char, #press>
        char[] arr = a.toCharArray();
        int n = arr.length;
        List<Character> list = new ArrayList<>();
        for (Character c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (!list.contains(c))  list.add(c);
        }
        Collections.sort(list, (o1, o2) -> (map.get(o2) - map.get(o1)));

        int numOfKeys = list.size();
        int reqTwice = Math.max(0, numOfKeys - 9);
        int reqThrice = Math.max(0, numOfKeys - 9 * 2);
        int count = n + reqTwice + reqThrice;
        return count;

    }


    public static void main(String[] args) {
            String a = "abacadefghibj";
// System.out.println(minPress(a));
        int hello = minPress("hello");
        int aba = minPress(a);
        System.out.println(hello);
        System.out.println(aba);

    }
}
