class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // two pointer
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) return new int[]{left+1, right+1};
            else if (temp > target) right--;
            else left++;
        }
        return new int[]{left+1, right+1};
    }
}
