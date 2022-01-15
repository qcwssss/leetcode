https://drive.google.com/drive/folders/1Is7T0zhqUfOCq0Juj690koy1t_7SobTF

##### merge intervals https://leetcode.com/problems/merge-intervals/

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0])); //O(nlogn)
            // sort the list by their star value
            //[1,3][2,4] -> [1,4]    
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] i : intervals){
            
            // if there is no overlap, add the value to merge list
            if(merged.isEmpty() || merged.getLast()[1] < i[0]) {
                merged.add(i);
            } else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);// O(n)
            }
            
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
// O(nlogn)+O(n) = O(nlogn)

https://1o24bbs.com/t/topic/7207.              发布于2019年4月的帖子

一个数列
处理之后满足两个要求：第一位要是1
之后每一位和他的前后位差值不能大于1
返回数列的最大值

Sort + 遍历

用人话就是如果这个数列没有重复的数字，返回数列的长度
如果有 比如4,5,6,6,7，返回的结果就是4，因为处理之后是1,2,3,3,4

 第一题是给两个数组和一个integer k，第一个数组answered代表每个小题已经回答过的题数，另一个needed代表每个小题需要回答的题数，k表示在剩余时间内还能完成的题数。求一共能完成多少题



##### distinct subarray


​        https://leetcode.com/playground/moffojJi

    class Solution:
        def distinctSubarrays(self, nums, k):
            odd = []
            m = len(nums)    
        for i, n in enumerate(nums):
            if n % 2:
                odd.append(i)
        res = 0
    
        for i in range(len(odd) - k + 1):
            left = odd[i]
            right = odd[i + k - 1]
            
            # find how many numbers on the left of left before another odd number
            if i == 0:
                left_len = left + 1
            else:
                left_len = odd[i] - odd[i - 1]
                
            # find how many numbers on the right of right before another odd number
            if i == len(odd) - k:
                right_len = m - right
            else:
                right_len = odd[i + k] - right
            
            # print(left, right, left_len, right_len)
            res += left_len * right_len
            
        return res
    sol = Solution()
    print(sol.distinctSubarrays([1,2,3,4,5], 2))
    print(sol.distinctSubarrays([1,5,3], 1))



##### common prefix length https://leetcode.com/discuss/interview-question/851513/Roblox-New-Grad-2021-OA-Hackerrank/875522

```
public int commonPrefix(String input) {
	int n = input.length();
	if(n == 0) return 0;

	int res = n;
	char[] arr = input.toCharArray();
	for(int i = 1; i < n; i++) {
		if(arr[i] == arr[0])
			res += getPrefixLength(arr, i);
	}

	return res;
}

public int getPrefixLength(char[] arr, int start) {
	int res = 0, i = 0, j = start;

	while(j < arr.length) {
		if(arr[i++] == arr[j++])
			res++;
		else
			break;
	}
	return res;
}
```



##### \992. Subarrays with K Different Integers https://leetcode.com/problems/subarrays-with-k-different-integers/

```
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        //main intution 
        return subarraysWithAtMostNDistinctNumbers(A,K) - subarraysWithAtMostNDistinctNumbers(A,K-1);
    }
    
    private int subarraysWithAtMostNDistinctNumbers(int[] A, int N) {
        
        int result = 0;
        int numberOfUniqueNumbersInCurrentSlidingWindow = 0;
        int left = 0;
        int right = 0;
        Map<Integer,Integer> slidingWindowCountMap = new HashMap<>();
        while(right < A.length) {
            int numAtRightIndex = A[right];
            slidingWindowCountMap.put(numAtRightIndex,slidingWindowCountMap.getOrDefault(numAtRightIndex,0)+1);
            
            while(slidingWindowCountMap.size() == N+1) {
                int numAtLeftIndex = A[left];
                int countOfNumAtLeftIndexInCurrentSlidingWindow = slidingWindowCountMap.get(numAtLeftIndex);
                
                //if the count is greaterThan 1 then we just decrement the count by 1
                //otherwise we remove it from the slidingWindowMap
                //We need to do this because our slidingWindowLogic is based on map size 
                if(countOfNumAtLeftIndexInCurrentSlidingWindow > 1) {
                    slidingWindowCountMap.put(numAtLeftIndex,countOfNumAtLeftIndexInCurrentSlidingWindow-1);
                } else {
                    slidingWindowCountMap.remove(numAtLeftIndex);
                }
                left++;
            }
            
            //when we get here, right index has definitely moved away from last time we took the count
            //additionally left index cound have moved as well, if the inner while loop was run 
            int numberOfSubArraysInCurrentSlidingWindowEndingAtRightIndex = right+1 - left;
            
            //Add the above number of unique subarrays to the final result 
            result += numberOfSubArraysInCurrentSlidingWindowEndingAtRightIndex;
            right++;
        }
        
        
        return result;
        
    }
    
}
```

##### \387. First Unique Character in a String


        

    class Solution {
        public int firstUniqChar(String s) {
            // two pointers
            if(s == null || s.length() == 0) {
                return -1;
            }
    		int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) -'a';
            count[index]++;
        }
        
        for (int i = 0; i < n; i++){
            int tmp = s.charAt(i) -'a';
            if(count[tmp] == 1) {
                return i;
            }
        }
       return -1;
    }

}
//O(n)
// O(1)

##### leetcode 1492  The kth Factor of n

class Solution {
    Queue<Integer> heap = new PriorityQueue<>((a,b) -> (b-a));
    public int kthFactor(int n, int k) {
        //maxheap
        //logk
        int sqr = (int) Math.sqrt(n);
        for(int i=1; i <=sqr; i++){
            if(n%i == 0) {
                heapPush(i, k);
                if(i != n/i) {
                   heapPush(n/i, k);  
                }
            }
        }
        return k == heap.size() ? heap.poll():-1;
    }
    public void heapPush(int x, int k) {
        heap.add(x);
        if(heap.size() >k) {
            heap.remove();
        }
    }
    
}
//O(sqrtN * logk)  O(min(k,sqrtN))

##### Answered Needed.   https://www.1point3acres.com/bbs/thread-830723-1-1.html



    Public class AnsweredNeeded{
        public static int answerdNeeded(List<Integer> answered, List<Integer> needed, int p) {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i< answered.size();i++){
                int a = needed[i] - answered[i];
                if(a < 0) temp.add(-1);
                else temp.add(a);
            }
        Arrays.sort(temp);
        int result = 0;
        for(int i = 0; i < temp.size() && q > 0;i++) {
            if(temp[i] <0) result++;
            else{
                q=q-temp.get(i);
                result++;
            }
        }
        return result;
    }
    }

##### \1481. Least Number of Unique Integers after K Removals https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/



```
 public int findLeastNumOfUniqueInts(int[] arr, int k) {
   
         HashMap<Integer, Integer> p = new HashMap<>();
         PriorityQueue<int[]> q= new PriorityQueue<>((a,b)-> a[1]-b[1]);  
        
        for(int i:arr){
            p.put(i,p.getOrDefault(i, 0) + 1);
        }
      
        for(int w:p.keySet()){
            q.offer(new int[]{w,p.get(w)});
        }
       for(int i=0;i<k;i++){
           int a[]=q.poll();
           if(a[1]>1){
               a[1]--;
               q.offer(a);
           
    }
       }
        return q.size();
   
    }
```

**Given a list of items in groups, perform certain operations in order to satisfy the constaints required by packaging automation.**
**The conditions are as follows**

```
public class M13
    {
        public int Packaging(int[] arr)
        {
            Array.Sort(arr);
            int[] dp = new int[arr.Length];
            dp[0] = 1;
            for (int i = 1; i < arr.Length; i++)
            {
                int required = dp[i - 1];
                dp[i] = Math.Max(required, Math.Min(required + 1, arr[i]));
            }

            return dp[arr.Length - 1];
        }
```

##### \2104. Sum of Subarray Ranges https://leetcode.com/problems/sum-of-subarray-ranges/

```
    public long subArrayRanges(int[] A) {
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i], min = A[i];
            for (int j = i; j < A.length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                res += max - min;
            }
        }
        return res;
    }
```

https://leetcode.com/problems/sum-of-subarray-ranges/discuss/1624222/JavaC%2B%2BPython-O(n)-solution-detailed-explanation





https://r24zeng.gitbook.io/amazon-prepare-2021/leetcode/29.-max-final-value-in-array

https://leetcode.com/discuss/interview-question/851513/roblox-new-grad-2021-oa-hackerrank

##### \1120. Maximum Average Subtree https://leetcode.com/problems/maximum-average-subtree/



    class Solution {
        // for each node in the tree, we will maintain three values
        class State {
            // count of nodes in the subtree
            int nodeCount;
        // sum of values in the subtree
        int valueSum;
    
        // max average found in the subtree
        double maxAverage;
    
        State(int nodes, int sum, double maxAverage) {
            this.nodeCount = nodes;
            this.valueSum = sum;
            this.maxAverage = maxAverage;
        }
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        return maxAverage(root).maxAverage;
    }
    
    State maxAverage(TreeNode root) {
        if (root == null) {
            return new State(0, 0, 0);
        }
    
        // postorder traversal, solve for both child nodes first.
        State left = maxAverage(root.left);
        State right = maxAverage(root.right);
    
        // now find nodeCount, valueSum and maxAverage for current node `root`
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        int sum = left.valueSum + right.valueSum + root.val;
        double maxAverage = Math.max(
                (1.0 * (sum)) / nodeCount, // average for current node
                Math.max(right.maxAverage, left.maxAverage) // max average from child nodes
        );
    
        return new State(nodeCount, sum, maxAverage);
    }
    }



https://leetcode.com/discuss/interview-question/1528869/amazon-oa-ng-2021

https://leetcode.com/discuss/interview-question/1195171/amazon-oa-finding-the-number-of-groups-may-2021

https://leetcode.com/problems/first-unique-character-in-a-string/

https://leetcode.com/problems/the-kth-factor-of-n/

