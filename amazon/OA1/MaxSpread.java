public class MaxSpread {
    public static int arrange(int[] arr, int diff) {
        Arrays.sort(arr);
        int res = 1;
        int l = 0, r = 0;
        while (r < arr.length) {
            if (arr[r] - arr[l] <= diff) {
                r++;
            } else {
                l = r;
                res++;
            }
        }
        return res;
    }

    public static void main(String []args) {
        int[] a1 = new int[] {1, 2, 3, 4, 5,9,11,18 };
        int k1 = 2;
        
        int[] a2 = new int[] {3，2，1，4，7 };
        int k1 = 2;


        System.out.println(arrange(a1, k1));
        System.out.println(arrange(a2, k1));
    }
}