class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouping = new HashMap<>();
        for (String str:strs) {
            char[] c = new char[26];
            for(char sChar: str.toCharArray()) {
                c[sChar-'a']++;
            }
            grouping.computeIfAbsent(String.valueOf(c), (a) -> new ArrayList<String>()).add(str);
        }
        return new ArrayList<>(grouping.values());
    }
}
