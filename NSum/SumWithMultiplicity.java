public class SumWithMultiplicity {
  // https://leetcode.com/problems/3sum-with-multiplicity/discuss/181098/JavaPython-3-O(n2)-and-O(n-%2B-101-2)-codes-w-brief-anslysis.
  public int threeSumMulti(int[] A, int target) {
          Arrays.sort(A);
          long res = 0;
          for (int i = 0; i < A.length - 2; ++i) {
              int j = i + 1;
              int k = A.length - 1;
              while (j < k) {
                  if (A[j] + A[k] < target - A[i]) {
                      ++j;
                  }else if (A[j] + A[k] > target - A[i]) {
                      --k;
                  }else {
                      int l = 1, r = 1;
                      while (j + l < k && A[j + l] == A[j]) { ++l; } // l: number of elements equal to A[j].
                      while (j + l <= k - r && A[k - r] == A[k]) { ++r; } // r: number of elements equal to A[k].
                      // If A[j...k] are all equal, then there are C(k - j + 1, 2) cases
                      // that meet the requirement;
                      // Otherwise, there are l * r cases that meet the requirement.
                      res += A[j] == A[k] ? (k - j + 1) * (k - j) / 2 : l * r ;
                      j += l; // forward j by l steps.
                      k -= r; // backward k by r steps.
                  }
              }
          }
          return (int)(res % 1_000_000_007);
      }
}
