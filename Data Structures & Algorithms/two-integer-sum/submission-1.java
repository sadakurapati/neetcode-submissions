class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return new int[]{-1, -1};
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int lookingFor = target - nums[i];
            if (seen.containsKey(lookingFor)) {
                return new int[]{seen.get(lookingFor), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Could not find it.
    }
}
