class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> leftCharCounts = constructCharCounts(s);
        Map<Character, Integer> rightCharCounts = constructCharCounts(t);
        return leftCharCounts.equals(rightCharCounts);
    }

    public Map<Character, Integer> constructCharCounts(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();
        if (str == null || str.length() == 0) return charCounts;
        for(Character c: str.toCharArray()) {
            charCounts.merge(c, 1, Integer::sum);
        }
        return charCounts;
    }
}
