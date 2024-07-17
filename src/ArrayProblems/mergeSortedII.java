package ArrayProblems;

public class mergeSortedII {
    public static int firstOccur(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        } else if (start == end) {
            return (nums[start] == k ? start : -1);
        } else {
            int mid = start + (end - start) / 2;
            if (nums[mid] < k) {
                return firstOccur(nums, mid + 1, end, k);
            } else if (nums[mid] > k) {
                return firstOccur(nums, start, mid - 1, k);
            } else {
                if (mid == 0 || nums[mid - 1] != k) {
                    return mid;
                }
                return firstOccur(nums, start, mid - 1, k);
            }
        }
    }
    public static int lastOccur(int[] nums,int start,int end,int k){
        if(start>end){
            return -1;
        } else if (start==end) {
            return (nums[start]==k ? start:-1);
        }else{
            int mid=start+(start+end)/2;
            if(nums[mid]<k){
                return firstOccur(nums,mid+1,end,k);
            } else if (nums[mid]>k) {
                return firstOccur(nums,start,mid-1,k);
            }else{
                if ((mid == end) || (mid + 1 <= end && nums[mid] < nums[mid + 1]))
                    return mid;
                return lastOccur(nums, mid + 1, end, k);
            }
        }
    }
    public static int[] firstAndLastOccurrence(int[] nums,int k){
        int first=firstOccur(nums,0,nums.length-1,k);
        int second=lastOccur(nums,0,nums.length-1,k);
        return new int[]{first,second};
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = firstAndLastOccurrence(nums, target);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
}
