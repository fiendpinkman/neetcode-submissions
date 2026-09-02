class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> groupAnagrams = new HashMap<>();
      for (String str: strs){
        char[] strArray = str.toCharArray();
        int[] count = new int[26];
        for (char strChar: strArray) {
            count[strChar - 'a']++;
        }
        String keyString = Arrays.toString(count);
        groupAnagrams.putIfAbsent(keyString, new ArrayList<>());
        groupAnagrams.get(keyString).add(str);
      }
      return new ArrayList<>(groupAnagrams.values());  
    }
}
