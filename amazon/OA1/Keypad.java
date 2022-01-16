public class KeyPad {
    public static int minPress(String a) {
        Map<Character, Integer> map = new HashMap<>(); // <char, #press>
        char[] arr = a.toCharArray();
        int n = arr.length;
        for (Character c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Collections.sort(arr, (o1, o2) -> (map.get(o2) - map.get(o1)));
        char prev = arr[0];
        int buttons = 1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            char cur = arr[i];
            if (cur != prev) {
                if (buttons % 9 > 0 && buttons % 9 < 2) {
                    buttons++;
                } else if (buttons % 9 > 2) {
                    buttons += 2;
                }
                buttons++;
                prev = cur;
            }
        }
        return count + n;
    }

    public static int minClickCount(String input) {
        int times = 0;
        char[] arr = input.toCharArray();
        for (char c : arr) {
            time += (c - 'a') / 9 + 1;
        }
        return times;
    }

    public static void main(String []args) {
        String a = "abacadefghibj";


        System.out.println(minPress(a));
    }
}