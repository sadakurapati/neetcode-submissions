class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null) return s1 == null;
        if (s1.length() > s2.length()) return false;
        var s1Map = getCharCounts(s1);
        var runningCharMap = getCharCounts(s2.substring(0, s1.length()));
        for(int i = s1.length(); i < s2.length(); i++) {
            if (s1Map.equals(runningCharMap)) return true;
            Character toAdd = s2.charAt(i);
            runningCharMap.merge(toAdd, 1, Integer::sum);
            Character toRemove = s2.charAt(i - s1.length());
            runningCharMap.computeIfPresent(toRemove, (key, value) -> value > 1 ? value - 1 : null);
        }
        return s1Map.equals(runningCharMap);
    }
    private Map<Character, Integer> getCharCounts(String str) {
        Map<Character, Integer> cMap = new HashMap<>();
        for(char c: str.toCharArray()) {
            cMap.merge(c, 1, Integer::sum);
        }
        return cMap;
    }
}
