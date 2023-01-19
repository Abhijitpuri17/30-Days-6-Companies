class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n ; i++) {
            leftMin[i] = min;
            min = Math.min(min, nums[i]);
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = n-1; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, nums[i]);
            if(rightMax[i] > nums[i] && leftMin[i] < nums[i])
                return true;
        }
            
        return false;
    }
}
