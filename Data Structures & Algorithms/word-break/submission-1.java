class Solution {
    Map<String, Boolean> subWordState = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        // Cached result
        if (subWordState.containsKey(s)) return subWordState.get(s);
        for(String word: wordDict){
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                return true;
            } 
        }
        subWordState.put(s, false);
        return false;
    }
}
