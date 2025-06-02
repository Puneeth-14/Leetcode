class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int maxlength = 0;
        int zerocount = 0;

        for(int right =0 ;right<n ;right++){
            if(nums[right] == 0){
                zerocount++;
            }
            if(zerocount > k){
                if(nums[left] == 0){
                    zerocount--;
                }
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);
        }
        return maxlength;
        
    }
}