class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null) return s1 == null;
        if (s1.length() > s2.length()) return false;

        var s1Map = getCharCounts(s1);
        var runningCharMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s2.length(); i++) {
            // 1. Add the current character to the window
            char toAdd = s2.charAt(i);
            runningCharMap.merge(toAdd, 1, Integer::sum);

            // 2. Once the window reaches s1's size, check and slide
            if (i >= s1.length() - 1) {
                if (s1Map.equals(runningCharMap)) return true;

                // Slide the left edge out of the window before the next iteration
                char toRemove = s2.charAt(i - s1.length() + 1);
                runningCharMap.computeIfPresent(toRemove, (key, val) -> val > 1 ? val - 1 : null);
            }
        }
        return false;
    }
    private Map<Character, Integer> getCharCounts(String str) {
        Map<Character, Integer> cMap = new HashMap<>();
        for(char c: str.toCharArray()) {
            cMap.merge(c, 1, Integer::sum);
        }
        return cMap;
    }
}
