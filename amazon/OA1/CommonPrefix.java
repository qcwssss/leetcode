// Java implementation of the above approach

public class CommonPrefix{
    
    public static List<Integer> prefixSum(List<String> input) {
        List<Integer> res = new ArrayList<>();
        for (String str : input) {
            int sum = commonPrefixSum(str);
            res.add(sum);
        }
        return res;

    }

    // Function to return the similarity sum
    static int commonPrefixSum(String input) {
            int n = input.length();
            int sum = n;
            char[] arr = input.toCharArray();
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[0]) {
                    sum += getPrefixLength(arr, i);
                }
            }
            return sum;
    }
    
    static int getPrefixLength(char[] arr, int start) {
        int res = 0; 
        int i = 0, j = start;
        while (j < arr.length) {
            if (arr[i++] == arr[j++]) {
                res++;
            } else {
                break;
            }
        }
        return res;

    }

// Driver code
    public static void main(String []args) {
        List<String> input = new LinkedList<>();
        String s = "abcabcd";	
        String s2 = "ababaa";    
        String s3 = "aa";
        input.add(s);
        input.add(s2);
        input.add(s3);



        System.out.println(prefixSum(input));
    }
}
