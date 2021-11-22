class MounttainPeakIndex {
    /*
    852. Peak Index in a Mountain Array
    Easy
    */

    public int peakIndexInMountainArray_2(int[] arr) {
        int i = 1;
        while (arr[i - 1] < arr[i]) i++;
        return i-1;
    }
    
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l)/2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    

}