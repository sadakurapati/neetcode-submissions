class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> groups = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray(); 
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }
        var result = new ArrayList<List<String>>();
        for(var entry: groups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
