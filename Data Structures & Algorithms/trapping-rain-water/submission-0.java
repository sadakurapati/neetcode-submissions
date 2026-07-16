class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int totalWater = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }
        return totalWater;
    }
}
