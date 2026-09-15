class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> iMap = new HashMap<>();
        for (String str: strs) {
            int[] cArray = new int[26];
            for (char c: str.toCharArray()) {
                cArray[c-'a']++;
            }
            iMap.computeIfAbsent(Arrays.toString(cArray), a -> new ArrayList<String>()).add(str);
        }
        return new ArrayList<>(iMap.values());
    }
}
