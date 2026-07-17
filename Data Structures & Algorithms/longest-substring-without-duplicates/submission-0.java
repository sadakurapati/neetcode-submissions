class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> seen = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            // Seen & within current window
            if (seen.containsKey(c) && seen.get(c) >= left) {
                left = seen.get(c) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            seen.put(c, right);
        }
        return maxLength;
    }
}
