class Solution {
    record WordProcessingState(String word, int currentIndex){
        boolean reachedAtEnd() {
            return currentIndex == word.length();
        }
        boolean isCurrentIndexValid() {
            return currentIndex < word.length();
        }
        char getCurrentChar() {
            return word.charAt(currentIndex);
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return canFormFromHere(new WordProcessingState(s1, 0), new WordProcessingState(s2, 0), new WordProcessingState(s3, 0), new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    private boolean canFormFromHere(WordProcessingState inputWord1, WordProcessingState inputWord2, WordProcessingState targetWord, Boolean[][] memo) {
        if (targetWord.reachedAtEnd()) {
            return inputWord1.reachedAtEnd() && inputWord2.reachedAtEnd();
        }
        if (memo[inputWord1.currentIndex()][inputWord2.currentIndex()] != null) return memo[inputWord1.currentIndex()][inputWord2.currentIndex()];
        
        boolean res = false;
        if (inputWord1.isCurrentIndexValid() && inputWord1.getCurrentChar() == targetWord.getCurrentChar()) {
            res = canFormFromHere(new WordProcessingState(inputWord1.word(), inputWord1.currentIndex() + 1), inputWord2, new WordProcessingState(targetWord.word(), targetWord.currentIndex() + 1), memo);
        }
        if (!res && inputWord2.isCurrentIndexValid() && inputWord2.getCurrentChar() == targetWord.getCurrentChar()) {
            res = canFormFromHere(inputWord1, new WordProcessingState(inputWord2.word(), inputWord2.currentIndex() + 1), new WordProcessingState(targetWord.word(), targetWord.currentIndex() + 1), memo);
        }
        return memo[inputWord1.currentIndex()][inputWord2.currentIndex()] = res;
    }
}
