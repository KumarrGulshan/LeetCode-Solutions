class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<=nums.length; i++){
           int reqnum = target - nums[i];
           if (map.containsKey(reqnum))
            {
                return new int[]{map.get(reqnum), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String [] args){
        int nums[]=new int[]{2,7,11,15};
        int target = 5;
        int[] result=twoSum(nums,9);
        System.out.println("index of the array is "+result);
    }
}
