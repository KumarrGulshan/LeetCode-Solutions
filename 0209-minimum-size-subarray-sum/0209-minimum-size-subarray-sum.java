class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int currentsum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            currentsum += nums[right];
            while (currentsum >= target){
                minLength = Math.min(minLength, right-left+1);
                currentsum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
}