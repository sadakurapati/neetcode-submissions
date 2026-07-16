class Solution {
    Boolean[][] memo;
    record WordState(String word, int index){
        boolean atEnd() {
            return index == word.length();
        }
        boolean isValid() {
            return index < word.length();
        }
        char currChar() {
            return word.charAt(index);
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return canFormFromHere(new WordState(s1, 0), new WordState(s2, 0), new WordState(s3, 0));
    }

    private boolean canFormFromHere(WordState inputWord1, WordState inputWord2, WordState targetWord) {
        if (targetWord.atEnd()) {
            return inputWord1.atEnd() && inputWord2.atEnd();
        }
        if (memo[inputWord1.index()][inputWord2.index()] != null) return memo[inputWord1.index()][inputWord2.index()];
        
        boolean res = false;
        if (inputWord1.isValid() && inputWord1.currChar() == targetWord.currChar()) {
            res = canFormFromHere(new WordState(inputWord1.word(), inputWord1.index() + 1), inputWord2, new WordState(targetWord.word(), targetWord.index() + 1));
        }
        if (!res && inputWord2.isValid() && inputWord2.currChar() == targetWord.currChar()) {
            res = canFormFromHere(inputWord1, new WordState(inputWord2.word(), inputWord2.index() + 1), new WordState(targetWord.word(), targetWord.index() + 1));
        }
        return memo[inputWord1.index()][inputWord2.index()] = res;
    }
}
