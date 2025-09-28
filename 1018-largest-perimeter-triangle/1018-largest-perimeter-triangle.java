class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  // Sort the array in ascending order
        
        // Start from the largest values and check triplets
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i], b = nums[i - 1], c = nums[i - 2];
            // Check triangle condition: sum of two smaller sides > largest side
            if (b + c > a) {
                return a + b + c;
            }
        }
        
        return 0;  // No valid triangle found
    }
}
