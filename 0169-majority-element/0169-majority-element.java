class Solution {
    public int majorityElement(int[] nums) {
        int numbers=0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
        if(count==0){
            numbers = nums[i];
        }
        if(numbers == nums[i]){
            count++;
        }
        else{
        count--;
        }
        }
        return numbers;
    }
}