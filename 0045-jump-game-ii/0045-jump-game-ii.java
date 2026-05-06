class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1)return 0;
        int jump =0;
        int currentend =0;
        int minStep =0;
        for(int i=0; i< nums.length; i++){
            minStep = Math.max(minStep, i + nums[i]);
            if(i == currentend){
                jump++;
            
            currentend = minStep;
            
            if(currentend >= nums.length-1){
               break;
            }
            }
        }
        return jump;
    }
}